package interfaces;

import models.User;

public class SmsNotification implements NotificationObserver{
    private User user;

    public SmsNotification(User user) {
        this.user = user;
    }

    @Override
    public void update(String message) {
        System.out.println("SMS to " + user.getPhone() + ": " + message);
    }

    @Override
    public String getType() {
        return "SMS";
    }

    @Override
    public User getUser() {
        return user;
    }
}
