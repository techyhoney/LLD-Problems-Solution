package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import interfaces.EmailNotification;
import interfaces.NotificationImpl;
import interfaces.NotificationObserver;
import interfaces.PushNotification;
import interfaces.SmsNotification;
import models.User;

public class NotificationService {
    private HashMap<String,User> users;
    private HashMap<String, List<NotificationObserver>> userNotificationObservers;
    private static NotificationService instance;
    private NotificationImpl notificationImpl;

    private NotificationService(){
        users=new HashMap<>();
        userNotificationObservers = new HashMap<>();
        notificationImpl = new NotificationImpl();
    }

    public static NotificationService getInstance(){
        if(instance==null){
            synchronized(NotificationService.class){
                if(instance==null){
                    instance = new NotificationService();
                }
            }
        }
        return instance;
    }

    public void addUser(User user){
        users.put(user.getId(), user);
    }
    
    public void subscribe(String userId, String type){
        User user = users.get(userId);
        NotificationObserver observer = null;

        switch (type) {
            case "Email":
                observer=new EmailNotification(user);
                break;
            case "SMS":
                observer=new SmsNotification(user);
                break;
            case "Push":
                observer=new PushNotification(user);
                break;
            default:
                break;
        }

        if(observer!=null){
            userNotificationObservers.putIfAbsent(userId, new ArrayList<>());
            List<NotificationObserver> userObservers = userNotificationObservers.get(userId);
            userObservers.add(observer);
            notificationImpl.addObservers(observer);
            user.addNotificationType(type);
        }
    }

    public void unsubscribe(String userId, String type){
        User user = users.get(userId);
        List<NotificationObserver> userObservers = userNotificationObservers.get(userId);
        NotificationObserver observer = null;

        for(NotificationObserver o: userObservers){
            if(o.getType().equals(type)){
                observer = o;
                break;
            }
        }

        if(observer!=null){
            userObservers.remove(observer);
            notificationImpl.removeObservers(observer);
            user.removeNotificationType(type);
        }
    }

    public void sendNotificationToUser(String userId, String message){
        notificationImpl.sendNotificationToUser(message, userId);
    }

    public void sendNotification(String message){
        notificationImpl.sendNotification(message);
    }
    
}
