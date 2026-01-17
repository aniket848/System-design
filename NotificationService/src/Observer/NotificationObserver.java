package Observer;

import Observable.NotificationObservable;
import Service.NotificationService;
import strategy.NotificationStrategy;

import java.util.ArrayList;
import java.util.List;

public class NotificationObserver implements IObserver{

    private List<NotificationStrategy> notificationStrategyList;
    private NotificationObservable notificationObservable;

    public NotificationObserver(){
        notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
        notificationStrategyList = new ArrayList<>();
    }

    @Override
    public void update() {
        String content = notificationObservable.getLatestNotification().getContent();
        for(NotificationStrategy notificationStrategy:notificationStrategyList){
            notificationStrategy.sendNotification(content);
        }
    }

    public void addNotificationStrategy(NotificationStrategy strategy){
        notificationStrategyList.add(strategy);
    }

    public void removeNotificationStrategy(NotificationStrategy strategy){
        notificationStrategyList.remove(strategy);
    }


}
