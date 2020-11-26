import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotificationManger {
    ArrayList<Notification> allNotifications = new ArrayList<Notification>();
    static Statistics stat = new Statistics();


    public NotificationManger() {
    }

    public void createNotification(String receiver , String name ,String templateName , String channel) throws IOException{
    	Template template = new Template();
    	stat.checkReceiver(receiver);
    	stat.checkTemplates(templateName);
        Notification notifi = new Notification(receiver, name, templateName, template.getContent(templateName), channel);
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
