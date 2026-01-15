import java.rmi.Remote;
import java.util.List;

interface Command{
    public void execute();
    public void undo();
}

class Light{
    public void on(){
        System.out.println("Light on...");
    }

    public void off(){
        System.out.println("Light off...");
    }
}

class Fan{
    public void on(){
        System.out.println("Fan on...");
    }

    public void off(){
        System.out.println("Fan off...");
    }
}

class lightCommand implements Command{

    private Light light;

    lightCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class fanCommand implements Command{

    private Fan fan;

    fanCommand(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}

class remoteControl{

    private static final Integer totalButtons = 4;
    private Command[] buttons;
    private Boolean[] isPressed;

    remoteControl(){
        buttons = new Command[totalButtons];
        isPressed = new Boolean[totalButtons];
    }

    public void setCommand(Command c, Integer idx){
        if(idx<totalButtons){
            buttons[idx] = c;
            isPressed[idx] = false; //when new command set, make it as non pressed or reset it.
        }
    }

    public void execute(Integer idx){
        if(idx<totalButtons && buttons[idx]!=null){
            if(!isPressed[idx]){
                buttons[idx].execute();
            }
            else{
                buttons[idx].undo();
            }
            isPressed[idx] = !isPressed[idx];
        }
        else if(idx<totalButtons && buttons[idx]==null){
            System.out.println("Command is not set for button no-: "+ idx + " , Please check again.");
        }
        else{
            System.out.println("Incorrect remote number");
        }
    }

}


public class Main {
    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();

        remoteControl remote = new remoteControl();

        remote.setCommand(new lightCommand(light),0);
        remote.setCommand(new fanCommand(fan),1);

        remote.execute(0);
        remote.execute(0);

        remote.execute(3);

        remote.execute(1);
        remote.execute(1);

    }
}