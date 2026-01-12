package strategy;

import model.User;

public class SMSNotification implements notification{

    private String mobileNo;

    public SMSNotification(String mobileNo){
        this.mobileNo = mobileNo;
    }

    @Override
    public void notifyUser(User user) {
        System.out.println("User " + user.getName() + " is notified throught SMS using number "+ this.mobileNo);
    }
}
