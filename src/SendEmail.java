import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail implements SendNotification{
	boolean check = false;
	@Override
	public void send(Notification notification) {
		/*
		 * Properties is a key value store. We'll use is to store:
		 * - Host server
		 * - Authentication, we'll use Gmail server to send the email so it's gonna be 'true'
		 * - Port number
		 * - Encryption method, for Gmail it'll be 'true'
		 */
		Properties properties = new Properties();    
		properties.put("mail.smtp.host", "smtp.gmail.com");    
		properties.put("mail.smtp.auth", "true");    
		properties.put("mail.smtp.port", "587");    
		properties.put("mail.smtp.starttls.enable", "true");

		//Sender credentials
		String email = "notifications.system.module@gmail.com";
		String password = "notsys2020";

		//get Session   
		Session session = Session.getDefaultInstance(properties,    
				new javax.mail.Authenticator() {    
			protected PasswordAuthentication getPasswordAuthentication() {    
				return new PasswordAuthentication(email, password);  
			}    
		});    
		//compose message    
		Message msg = null;
		try {
			msg = prepareMessage(session, notification.receiver, notification);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}  
		try {
			Transport.send(msg);
			System.out.println("Notification sent successfully");
			check = true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	//this will prepare the message to be send
	private static Message prepareMessage(Session session, String recipient, Notification notification) throws AddressException, MessagingException {
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Notification System <notifications.system.module@gmail.com>"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));    
			message.setSubject(notification.subject);    
			message.setText(notification.message, "utf-8", "html");    
			return message;
		} catch (Exception e) {
			System.out.println(e);
			//Logger.getLogger(JavaMailUtil.class.getName().log(Level.SEVERE, null, e));
		}
		return null;
	}

	@Override
	public boolean isSent() {
		return check;
	}
}