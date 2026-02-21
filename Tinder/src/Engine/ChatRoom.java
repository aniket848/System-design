package Engine;

import Model.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {

    private List<Long> participantIds;
    private List<Message> messages;
    private String roomId;

    public ChatRoom(String roomId, Long senderId, Long receiverId){
        this.roomId = roomId;
        participantIds = new ArrayList<>();
        participantIds.add(senderId);
        participantIds.add(receiverId);
        messages = new ArrayList<>();
    }

    public void sendMessage(Message message){
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void displayChat(){
        System.out.println("Chat Room: " + roomId);
        for(Message message : messages){
            System.out.println(message.getContent());
        }
    }

}
