package Content;

public class timeStampDecorator extends ContentDecorator{

    public timeStampDecorator(INotificationContent notificationContent){
        super(notificationContent);
    }

    @Override
    public String getContent() {
        return "[17th Jan 2026, 06:30 PM] "+ notificationContent.getContent();
    }
}
