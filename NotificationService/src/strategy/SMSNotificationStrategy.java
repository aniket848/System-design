package strategy;

public class SMSNotificationStrategy implements NotificationStrategy{

    private String MobileNo;

    public SMSNotificationStrategy(String mobileNo){
        this.MobileNo = mobileNo;
    }


    @Override
    public void sendNotification(String notification) {
        System.out.println("[ "+notification + "] is send by SMS through mobile No: "+MobileNo);
    }
}
