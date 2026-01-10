interface walk{
    public void walk();
}

class walkable implements walk{
    @Override
    public void walk() {
        System.out.println("This Robot can walk");
    }
}

class nonWalkable implements walk{
    @Override
    public void walk() {
        System.out.println("This Robot cannot walk");
    }
}

interface talk{
    public void talk();
}

class talkable implements talk{
    @Override
    public void talk() {
        System.out.println("This robot can talk");
    }
}

class singable implements talk{
    @Override
    public void talk() {
        System.out.println("This robot can only sing songs");
    }
}

class nonTalkable implements talk{
    @Override
    public void talk() {
        System.out.println("This robot can't talk");
    }
}

interface fly{
    public void fly();
}

class jetFly implements fly{
    @Override
    public void fly() {
        System.out.println("This robot can fly using JET Engine technology");
    }
}

class noFly implements fly{
    @Override
    public void fly() {
        System.out.println("This Jet can't be fly");
    }
}


abstract class robot{
    walk wk;
    talk tk;
    fly fk;

    robot(walk wk, talk tk, fly fk){
        this.wk = wk;
        this.tk = tk;
        this.fk = fk;
    }

    public void walk(){
        wk.walk();
    }

    public void talk(){
        tk.talk();
    }
    public void fly(){
        fk.fly();
    }

    public abstract void projection();
}


class companionRobot extends robot{

    companionRobot(walk wk, talk tk, fly fk){
        super(wk,tk,fk);
    }

    @Override
    public void projection() {
        System.out.println("It looks like simple robot to help on daily work");
    }
}

class humanoidRobot extends robot{

    humanoidRobot(walk wk, talk tk, fly fk){
        super(wk,tk,fk);
    }

    @Override
    public void projection() {
        System.out.println("It looks like Human Being and can also perform same operation");
    }
}

public class StrategyDesignPattern {
    public static void main(String[] args) {

        companionRobot robot1 = new companionRobot(new walkable(),new nonTalkable(),new noFly());
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();
        
        humanoidRobot robot2 = new humanoidRobot(new walkable(), new singable(), new jetFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();


    }
}