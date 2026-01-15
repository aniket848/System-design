import java.util.ArrayList;
import java.util.List;

interface ISubscriber {
   public void update();
}

interface IChannel{
    public void addSubscriber(Subscriber subs);
    public void removeSubscriber(Subscriber subs);
    public void notifyAllSubscriber();
}

class Channel implements IChannel{

    private List<Subscriber> subscriberList;
    private String latestVideo;
    private String channelName;

    Channel(String name){
        subscriberList = new ArrayList<>();
        latestVideo = "";
        channelName = name;
    }

    @Override
    public void addSubscriber(Subscriber subs) {
        subscriberList.add(subs);
    }

    @Override
    public void removeSubscriber(Subscriber subs) {
        subscriberList.remove(subs);
    }

    @Override
    public void notifyAllSubscriber() {
        for(Subscriber subs:subscriberList){
            subs.update();
        }
    }

    public void uploadVideo(String videoName){
        System.out.println("New video uploaded -: "+ videoName);
        latestVideo = videoName;
        notifyAllSubscriber();
    }

    public String getLatestVideo(){
        return latestVideo;
    }

    public String getChannelName(){
        return channelName;
    }
}

class Subscriber implements ISubscriber {

    private Channel channel;
    private String name;

    Subscriber(Channel channel, String userName){
        this.channel = channel;
        this.name = userName;
    }

    @Override
    public void update() {
        System.out.println(name + " is updated that new video is uploaded -: '"+ channel.getLatestVideo() + "' by channel -: "+channel.getChannelName());
    }
}


public class Main {
    public static void main(String[] args) {

        Channel ch1 = new Channel("Apni Kaksha");
        Channel ch2 = new Channel("Pawn stars");

        Subscriber sub1 = new Subscriber(ch1,"aniket");
        Subscriber sub2 = new Subscriber(ch1,"komal");
        Subscriber sub3 = new Subscriber(ch2,"komal");
        Subscriber sub4 = new Subscriber(ch1,"Harsh");

        ch1.addSubscriber(sub1);
        ch1.addSubscriber(sub2);
        ch1.addSubscriber(sub4);
        ch2.addSubscriber(sub3);

        ch1.uploadVideo("Web Development course");
        ch1.removeSubscriber(sub2);
        ch1.uploadVideo("Spring Boot complete course");
        ch2.uploadVideo("Best collectable notes");
        ch2.addSubscriber(sub1);
        ch2.uploadVideo("Best antiquee car");
    }
}