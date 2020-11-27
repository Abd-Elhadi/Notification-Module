import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotificationManger {
    ArrayList<Notification> allNotifications = new ArrayList<Notification>();
    static Statistics stat = new Statistics();


    public NotificationManger() {
    }

    public void createNotification(String receiver, String name, String templateName, String placeholder1, String placeholder2 , String channel) throws IOException{
    	Template template = new Template();
    	String content = template.getContent(templateName);
    	if (!content.equals("NOT FOUND")) {
    	   	stat.checkTopReceiver(receiver);
        	stat.checkTopTemplate(templateName);
            Notification notifi = new Notification(receiver, name, placeholder1, placeholder2, templateName, content, channel);
            allNotifications.add(notifi);
    	} else {
    		System.out.println("Invalid Template Type");
    	}
    }

    public Statistics getStat(){
      return stat;
    }


    public void send(){
    	SendNotification sender;
    	for (int i = 0; i < allNotifications.size(); i++) {
    		if (allNotifications.get(i).getChannel().equalsIgnoreCase("email")) {
    			sender = new SendEmail();
    		} else {
    			sender = new SendSMS();
    		}
    		sender.send(allNotifications.get(i));
    		if (sender.isSent()) {
    			stat.incrementSent();
    		} else {
    			stat.incrementFailed();
    		}
    	}

    }

    public static void main(String[] args) throws IOException{
    	NotificationManger m = new NotificationManger();
    	m.createNotification("farabi.marwa@gmail.com", "marwa", "OrderShipped", "12345", "Amazon", "email");
    	m.send();
    }


}
