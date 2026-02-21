package Engine;

import Enums.SwipeAction;
import Model.userProfile;
import Model.userPreference;
import Observer.NotificationObserver;
import Observer.userNotificationObserver;
import Service.NotificationService;

import java.util.HashMap;

public class User {

    private Long userId;
    private userProfile profile;
    private userPreference preferences;
    private HashMap<Long, SwipeAction> swipeHistory;

    public User(Long userId, userProfile profile, userPreference preferences) {
        this.userId = userId;
        this.profile = profile;
        this.preferences = preferences;
        this.swipeHistory = new HashMap<>();
        NotificationObserver nob = new userNotificationObserver(profile.getName(), userId);
        NotificationService.getInstance().addObserver(userId,nob);
    }

    public void swipe(Long userId, SwipeAction action) {
        swipeHistory.put(userId, action);
    }

    public Boolean isLiked(Long userId){
        if(swipeHistory.containsKey(userId)){
            return swipeHistory.get(userId) == SwipeAction.RIGHT;
        }
        return false;
    }

    public Boolean isDisLiked(Long userId){
        if(swipeHistory.containsKey(userId)){
            return swipeHistory.get(userId) == SwipeAction.LEFT;
        }
        return false;
    }

    public Boolean hasInteractedWith(Long userId){
        return swipeHistory.containsKey(userId);
    }

    public void showUserProfile(){
        profile.showProfile();
    }

    public userPreference getPreferences() {
        return preferences;
    }

    public userProfile getProfile() {
        return profile;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserNameById(Long userId){
        if(this.userId.equals(userId)){
            return profile.getName();
        }
        return null;
    }
}
