package Observer;

public class userNotificationObserver implements NotificationObserver {
    private String name;
    private Long userId;

    public userNotificationObserver(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }

    @Override
    public void update(String mesg) {
        System.out.println("Notification for " + name + ": " + mesg);
    }
}

