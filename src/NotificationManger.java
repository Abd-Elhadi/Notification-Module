import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotificationManger {
    ArrayList<Notification> allNotifications = new ArrayList<Notification>();
    static Statistics stat = new Statistics();


    public NotificationManger() {
    }

    public void createNotification(String receiver , String name ,String templateType , String channel){
        Notification notifi = new Notification();
        String message = notifi.createMessage(name);
        notifi.setChannel(channel);
        notifi.setReceiver(receiver);
        notifi.setSubject(templateType);
        notifi.setMessage(message);
        allNotifications.add(notifi);
    }

    public Statistics getStat(){
      return stat;
    }


    public void send(){


    }

    public static void main(String[] args) {

        }


}
