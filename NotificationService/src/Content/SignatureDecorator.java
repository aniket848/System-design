package Content;

public class SignatureDecorator extends ContentDecorator{

    private String sign;

    public SignatureDecorator(INotificationContent notificationContent, String sign){
        super(notificationContent);
        this.sign = sign;
    }

    @Override
    public String getContent() {
        return notificationContent.getContent() + " Signed By: "+sign;
    }
}
