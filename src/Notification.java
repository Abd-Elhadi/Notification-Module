
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
	
	Notification (String receiver, String name, String subject, String template, String channel){
		this.receiver = receiver;
		this.subject = subject;
		this.channel = channel;
		createMessage(name, template);
	}
	
	public void createMessage(String name, String template) {
		String [] splitTemp = template.split(" ");
		String updatedTemplate = "";
		for (int i = 0; i < splitTemp.length; i++) {
			if (splitTemp[i].equals("%n")) {
				splitTemp[i] = name;
			}
		}
		for (int j = 0; j < splitTemp.length; j++) {
			updatedTemplate += splitTemp[j] + " ";
		}
		this.message = updatedTemplate;
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
