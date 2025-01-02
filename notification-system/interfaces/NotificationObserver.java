package interfaces;

import models.User;

public interface NotificationObserver {
    void update(String message);
    String getType();
    User getUser();
    
}