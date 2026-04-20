package org.example;

import java.util.ArrayList;
import java.util.List;

interface Mediator{

     public void send(String from, String mesg);
     public void sendPrivate(String from, String to, String mesg);
     public void register(Colleague colleague);
     public void mute(String who, String whom);
}

abstract class Colleague{
     protected Mediator mediator;

     public Colleague(Mediator m){
         this.mediator = m;
         mediator.register(this);
     }

     public abstract String getName();
     public abstract void send(String mesg);
     public abstract void sendPrivate(String to, String mesg);
     public abstract void receive(String from, String mesg);
     public abstract void mute(String whom);

}

class Pair<T,U>{
     private final T first;
     private final U second;

     Pair(T first, U second){
         this.first = first;
         this.second = second;
     }

     public T getFirst(){
         return first;
     }

     public U getSecond(){
         return second;
     }

}

class ChatMediator implements Mediator{

     private List<Colleague> colleagueList;
     private List<Pair<String,String>> mutedList;

     ChatMediator(){
         colleagueList = new ArrayList<>();
         mutedList = new ArrayList<>();
     }

    @Override
    public void send(String from, String mesg) {

        System.out.println("Broadcasting message from "+from+" : "+mesg);

        for(Colleague to: colleagueList){

            if(to.getName().equalsIgnoreCase(from)){
                continue;
            }

            boolean isMuted = false;
            for(Pair<String,String> p:mutedList){
                // to muted from
                if(p.getSecond().equalsIgnoreCase(from) && p.getFirst().equalsIgnoreCase(to.getName())){
                    isMuted = true;
                    break;
                }
            }//for

            if(!isMuted){
                to.receive(from,mesg);
            }

        }//for
    }//send

    @Override
    public void sendPrivate(String from, String to, String mesg) {

        System.out.println("Sending private message from "+from+" to "+to+" : "+mesg);

        for(Colleague c: colleagueList){

            if(c.getName().equalsIgnoreCase(to)){
                boolean isMuted = false;
                for(Pair<String,String> p:mutedList){
                    if(p.getSecond().equalsIgnoreCase(from) && p.getFirst().equalsIgnoreCase(to)){
                        isMuted = true;
                        break;
                    }
                }//for

                if(!isMuted){
                    c.receive(from,mesg);
                }
            }
        }


    }

    @Override
    public void register(Colleague colleague) {
        colleagueList.add(colleague);
    }

    @Override
    public void mute(String who, String whom) {
        mutedList.add(new Pair<>(who, whom));
    }
}

class User extends Colleague{

    private String name;

    User(String name, Mediator m){
        super(m);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void send(String mesg) {
         mediator.send(name,mesg);
    }

    @Override
    public void sendPrivate(String to, String mesg) {
         mediator.sendPrivate(name,to,mesg);
    }

    @Override
    public void receive(String from, String mesg) {
        System.out.println(name+" received message from "+from+" : "+mesg);
    }

    @Override
    public void mute(String whom) {
        mediator.mute(name,whom);
    }
}


public class Main {
    public static void main(String[] args) {

        Mediator mediator = new ChatMediator();

        Colleague user1 = new User("Aniket",mediator);
        Colleague user2 = new User("Harsh",mediator);
        Colleague user3 = new User("Swati",mediator);
        Colleague user4 = new User("Aman",mediator);

        user1.send("Hello everyone!");

        System.out.println("Swati muted Aniket");

        user3.mute("Aniket");

        user1.send("How's everyone doing?");

        user1.sendPrivate("Aman","Hey Aman, Pls inc my salary by 50%");

        user4.sendPrivate("Aniket","It's not in my hand aniket, let me talk to Dinesh");

        user4.send("I am on leave tomorrow, team make sure all assigned task will be completed");
    }
}