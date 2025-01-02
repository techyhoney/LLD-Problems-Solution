package models;

public class NotificationService {
    public void sendNotification(Notification notification, User user){
        System.out.println("Notification sent to "+user.getName()+" with content: "+notification.getContent());
    }
}
