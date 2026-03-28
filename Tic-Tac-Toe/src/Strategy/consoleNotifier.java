package Strategy;

public class consoleNotifier implements IObserver{
    @Override
    public void update(String mesg) {
        System.out.println(mesg);
    }
}
