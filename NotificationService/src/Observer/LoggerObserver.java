package Observer;

import Observable.IObservable;
import Observable.NotificationObservable;
import Service.NotificationService;

public class LoggerObserver implements IObserver{

    private NotificationObservable notificationObservable;

    public LoggerObserver(){
        notificationObservable =  NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    LoggerObserver(NotificationObservable notificationObservable){
        this.notificationObservable = notificationObservable;
    }

    @Override
    public void update() {
        String content = notificationObservable.getLatestNotification().getContent();
        System.out.println("Notification update in logger: "+ content);
    }
}
