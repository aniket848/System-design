import Content.INotificationContent;
import Content.NotificationContent;
import Content.SignatureDecorator;
import Content.timeStampDecorator;
import Observer.LoggerObserver;
import Observer.NotificationObserver;
import Service.NotificationService;
import strategy.EmailNotificationStrategy;
import strategy.PopupNotificationStrategy;
import strategy.SMSNotificationStrategy;

public class Main {
    public static void main(String[] args) {

        //Create notification service
        NotificationService notificationService = NotificationService.getInstance();

        // Create observers
        //LoggerObserver logger = new LoggerObserver();
        NotificationObserver notificationObserver = new NotificationObserver();

        // Create notification content
        INotificationContent content = new NotificationContent("Spotify video uploaded");
        System.out.println("simple notification: " +content.getContent());
        content = new timeStampDecorator(content);
        System.out.println("Notification with timestamp: " +content.getContent());
        INotificationContent content1 = new SignatureDecorator(content, "ANIKET");
        System.out.println("Notification with Sign & timestamp: " +content1.getContent());

        // Add notification strategy
        notificationObserver.addNotificationStrategy(new EmailNotificationStrategy("aniketm580@gmail.com"));
        notificationObserver.addNotificationStrategy(new SMSNotificationStrategy("+91 64982080646"));
        notificationObserver.addNotificationStrategy(new PopupNotificationStrategy());


        // send notification
        notificationService.sendNotification(content);
    }
}