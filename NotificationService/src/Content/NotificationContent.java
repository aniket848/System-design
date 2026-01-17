package Content;

public class NotificationContent implements INotificationContent{

    private String text;

    public NotificationContent(String text){
        this.text = text;
    }

    @Override
    public String getContent() {
        return text;
    }
}
