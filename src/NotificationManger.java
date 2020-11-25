import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotificationManger {
    Map<String,String> allTemplates=new HashMap<String,String>();
    ArrayList<notification> allNotifications = new ArrayList<notification>;
    static Statistics stat = new Statistics();


    public NotificationManger() {
    }

    public void createNotification(String receiver , String name ,String templateType , String channel){

    }

    public Statistics getStat(){
      return stat;
    }


    public void sendAll(){

    }

    public static void main(String[] args) {

        }


}
