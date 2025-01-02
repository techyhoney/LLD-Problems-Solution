package interfaces;

import models.User;

public class PushNotification implements NotificationObserver{
    private User user;
    
    public PushNotification(User user) {
        this.user = user;
    }

    @Override
    public void update(String message) {
        System.out.println("Sending Push Notification to " + user.getDeviceId() + ": " + message);
    }

    @Override
    public String getType() {
        return "Push";
    }

    @Override
    public User getUser() {
        return user;
    }
    
}
