package Model;

import java.text.SimpleDateFormat;

public class Message {

    private Long senderId;
    private String content;
    private Long timeStamp;

    public Message(Long senderId, String content) {
        this.senderId = senderId;
        this.content = content;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getFormattedTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(timeStamp);
    }

    public String getContent(){
        return "[" + getFormattedTime() + "]: " + "For UserId: "+ senderId + " - " + content;
    }
}
