package strategy;

public class EmailNotificationStrategy implements NotificationStrategy{

    private String email;

    public EmailNotificationStrategy(String email){
        this.email = email;
    }

    @Override
    public void sendNotification(String notification) {
        System.out.println("[ "+ notification + "] is sent by Email: "+email);
    }
}
