package Observable;

import Content.INotificationContent;
import Content.NotificationContent;
import Observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class NotificationObservable implements IObservable{

    private List<IObserver> observerList;
    private INotificationContent latestNotification;

    public NotificationObservable(){
        observerList = new ArrayList<>();
        latestNotification = null;
    }

    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
       for(IObserver observer: observerList){
           observer.update();
       }
    }

    public void sentLatestNotification(INotificationContent notificationContent){
        this.latestNotification = notificationContent;
        notifyObserver();
    }

    public INotificationContent getLatestNotification(){
        return latestNotification;
    }
}
