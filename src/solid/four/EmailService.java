package solid.four;

import solid.four.interfaces.INotificationService;

public class EmailService implements INotificationService {
    public void sendNotification(String to, String msg) {
        System.out.println("Sending email to " + to + ": " + msg);
    }
    public void sendAlert(String to, String alert) {
        System.out.println("ALERT to " + to + ": " + alert);
    }
}