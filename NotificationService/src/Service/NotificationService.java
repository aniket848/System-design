package Service;

import Content.INotificationContent;
import Observable.NotificationObservable;

import java.util.ArrayList;
import java.util.List;

//SINGLETON
public class NotificationService {

    private static NotificationService instance = null;
    private List<INotificationContent> notificationContentList;
    private NotificationObservable notificationObservable;

    private NotificationService(){
        notificationObservable = new NotificationObservable();
        notificationContentList = new ArrayList<>();
    }

    public static NotificationService getInstance(){
        if(instance == null){
            instance = new NotificationService();
        }
        return instance;
    }

    public void sendNotification(INotificationContent notificationContent){
        notificationContentList.add(notificationContent);
        notificationObservable.sentLatestNotification(notificationContent);
    }

    public NotificationObservable getObservable(){
        return notificationObservable;
    }

    public void showAllNotification(){
        for(INotificationContent content: notificationContentList){
            System.out.println(content.getContent());
        }
    }

}
