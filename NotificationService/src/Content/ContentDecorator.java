package Content;

abstract class ContentDecorator implements  INotificationContent{

    protected INotificationContent notificationContent;

    ContentDecorator(INotificationContent notificationContent){
        this.notificationContent = notificationContent;
    }
}
