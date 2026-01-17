package strategy;

public class PopupNotificationStrategy implements NotificationStrategy{

    @Override
    public void sendNotification(String notification) {
        System.out.println("[ "+notification + "] is send via popup");
    }
}
