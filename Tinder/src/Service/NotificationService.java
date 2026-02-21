package Service;

import Observer.NotificationObserver;

import java.util.HashMap;

//SINGLETON
public class NotificationService {

    private static NotificationService instance = null;
    private HashMap<Long, NotificationObserver> observers;

    private NotificationService() {
        observers = new HashMap<>();
    }

    public static NotificationService getInstance() {
        if(instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void addObserver(Long userId,NotificationObserver obs){
        observers.put(userId,obs);
    }

    public void removeObserver(Long userId){
        observers.remove(userId);
    }

    public void notifyUser(Long userId, String mesg){
        if(observers.containsKey(userId)){
            observers.get(userId).update(mesg);
        }
    }

    public void notifyAllUsers(String mesg){
        for(NotificationObserver obs: observers.values()){
            obs.update(mesg);
        }
    }
}
