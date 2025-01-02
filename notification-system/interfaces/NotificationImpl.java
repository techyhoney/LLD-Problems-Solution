package interfaces;

import java.util.ArrayList;
import java.util.List;

public class NotificationImpl implements Notification{
    List<NotificationObserver> observers = new ArrayList<>();

    @Override
    public void addObservers(NotificationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObservers(NotificationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for(NotificationObserver observer: observers){
            observer.update(message);
        }
    }

    public void sendNotification(String message){
        notifyObservers(message);
    }

    public void sendNotificationToUser(String message, String userId){
        for(NotificationObserver observer: observers){
            if(observer.getUser().getId().equals(userId)){
                observer.update(message);
            }
        }
    }
}
