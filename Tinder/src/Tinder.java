import Engine.ChatRoom;
import Engine.User;
import Enums.MatcherType;
import Enums.SwipeAction;
import Factory.MatcherFactory;
import Matcher.Matcher;
import Model.Message;
import Service.NotificationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tinder {

    private List<User> userList;
    private HashMap<String,ChatRoom> chatRoomList;
    private Matcher matcher;
    private NotificationService notificationService;

    public Tinder(){
        matcher = MatcherFactory.getInstance().createrMatcher(MatcherType.DISTANCE);
        notificationService = NotificationService.getInstance();
        chatRoomList = new HashMap<>();
        userList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public User getUserById(Long userId){
        for(User user : userList){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    public void swipe(Long userId,Long targetedUserId, SwipeAction swipeAction){

        if(userId == null || targetedUserId == null){
            System.out.println("Invalid userId or targetedUserId");
            return;
        }

        User user = getUserById(userId);
        User targetUser = getUserById(targetedUserId);
        user.swipe(targetedUserId, swipeAction);

        // match happen from both side, so notify and create chatRoom
        if(swipeAction == SwipeAction.RIGHT && targetUser.isLiked(userId)){
            String chatRoomId = userId + "_" + targetedUserId;
            ChatRoom chatRoom = new ChatRoom(chatRoomId, userId, targetedUserId);
            chatRoomList.put(chatRoomId,chatRoom);

            // After successful match, send notification to both users about new match
            notificationService.notifyUser(targetedUserId, "You have a new match with " + user.getProfile().getName());
            notificationService.notifyUser(userId, "You have a new match with " + targetUser.getProfile().getName());
            System.out.println("ChatRoom created with roomId: " + chatRoomId);
        }
    }

    public void sendMessage(Long senderId, Long receiverId, String mesg){
        String chatRoomId = senderId + "_" + receiverId;
        if(!chatRoomList.containsKey(chatRoomId) && !chatRoomList.containsKey(receiverId + "_" + senderId)){
            System.out.println("No chat room found for senderId: " + senderId + " and receiverId: " + receiverId);
            return;
        }

        if(chatRoomList.get(chatRoomId) == null){
            chatRoomId = receiverId + "_" + senderId;
        }

        ChatRoom chatRoom = chatRoomList.get(chatRoomId);
        chatRoom.sendMessage(new Message(senderId, mesg));
        // send notification to the receiver for received message
        notificationService.notifyUser(receiverId, "You have a new message from " + getUserById(senderId).getProfile().getName());
    }

    public void displayMessage(Long userId, Long otherUserId){
        String chatRoomId = userId + "_" + otherUserId;
        if(!chatRoomList.containsKey(chatRoomId) && !chatRoomList.containsKey(otherUserId + "_" + userId)){
            System.out.println("No chat room found for userId: " + userId + " and otherUserId: " + otherUserId);
            return;
        }

        if(chatRoomList.get(chatRoomId) == null){
            chatRoomId = otherUserId + "_" + userId;
        }
        ChatRoom chatRoom = chatRoomList.get(chatRoomId);
        chatRoom.displayChat();

    }

    public List<User> findMatches(Long userId){

        List<User> filteredUser = new ArrayList<>();
        User currentUser = getUserById(userId);
        for(User user: userList){
            if(currentUser.hasInteractedWith(userId) || user.getUserId().equals(userId)) // already interacted with the user, so skip
                  continue;
            Double score = matcher.calculateMatchScore(currentUser, user);
            if(score > 0.0){
                filteredUser.add(user);
            }
        }

        return filteredUser;
    }

}
