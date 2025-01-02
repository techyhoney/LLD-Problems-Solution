package interfaces;

public interface Notification {
    void addObservers(NotificationObserver observer);
    void removeObservers(NotificationObserver observer);
    void notifyObservers(String message);
}
