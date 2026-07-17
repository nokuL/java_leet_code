package solid.four.interfaces;

public interface INotificationService {
    public void sendNotification(String to, String msg);
    public void sendAlert(String to, String alert) ;
}
