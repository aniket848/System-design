package strategy;

import model.User;

public class EmailNotification implements notification{

    private String email;

    public EmailNotification(String email){
        this.email = email;
    }

    @Override
    public void notifyUser(User user) {
        System.out.println("User: "+ user.getName() + " is notified by email: "+ this.email);
    }
}
