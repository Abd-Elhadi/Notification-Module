import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SendSMS implements SendNotification{
	boolean check = false;
	@Override
	/*
	 * this will create a txt file with the recipient number
	 * and the notification will be written in the txt file with the following format
	 * The word *Subject* between the Asterisks followed by the notification and a new line.
	 * 
	 */
	public void send(Notification notification) {
		try (FileWriter fw = new FileWriter(notification.receiver + ".txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println("*" + notification.subject + "*");
			out.println(notification.message);
			out.println();
			check = true;
		} catch (IOException e) {
			//exception handling left as an exercise for the reader
		}
	}
	@Override
	public boolean isSent() {
		return check;
	}
}
