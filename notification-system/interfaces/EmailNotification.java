package interfaces;

import models.User;

public class EmailNotification implements NotificationObserver{
    private User user;

    public EmailNotification(User user) {
        this.user = user;
    }
    
    @Override
    public void update(String message) {
        System.out.println("Email to " + user.getEmail() + ": " + message);
    }

    @Override
    public String getType() {
        return "Email";
    }

    @Override
    public User getUser() {
        return user;
    }
}
