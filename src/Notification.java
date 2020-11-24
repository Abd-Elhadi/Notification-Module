
public class Notification {
	String subject;
	String message;
	String channel;
	String receiver;
	
	Notification (){
		subject = "";
		message = "";
		channel = "";
		receiver = "";
	}
	
	@SuppressWarnings("unused")
	private void createMessage() {
		
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
}
