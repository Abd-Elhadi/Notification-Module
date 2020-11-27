import java.util.Scanner;  

class Main {
	public static void main(String[] args) {
		
		Notification not = new Notification();
		Scanner sc = new Scanner(System.in);  

		System.out.println("Notification recipient: ");
		not.receiver = sc.nextLine();
		System.out.println("Notification subject: ");
		not.subject = sc.nextLine();
		System.out.println("Notification content: ");
		not.message = sc.nextLine();
		System.out.println("Notification channel: ");
		not.channel = sc.nextLine();
		
		SendEmail sender = new SendEmail();
		sender.send(not);
		if (sender.isSent()) System.out.println("Great!");
	}
}
