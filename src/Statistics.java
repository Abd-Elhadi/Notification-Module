import java.util.*;

public class Statistics {
	Map<String,Integer> allTemplates=new HashMap<String,Integer>();
	Map<String,Integer> allReceivers=new HashMap<String,Integer>();
	String topReceiver, topTemplate;
	int sentNotifications, failedNotifications;
	
	public void checkReceiver() {
		
	}
	public void checkTemplates(String templateName) {
		
	}
	public void incrementSent() {
		sentNotifications++;
	}
	public void incrementFailed() {
		failedNotifications++;
	}
	public String getTopReceiver() {
		return topReceiver;
	}
	public String getTopTemplate() {
		return topTemplate;
	}
	public int getSentNum() {
		return sentNotifications;
	}
	public int getFailedNum() {
		return failedNotifications;
	}
}
