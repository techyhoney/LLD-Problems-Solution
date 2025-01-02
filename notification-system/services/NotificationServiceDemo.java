package services;

import models.User;

public class NotificationServiceDemo {
    public static void run(){
        NotificationService notificationService = NotificationService.getInstance();
        User user1 = new User("U1001", "alice@gmail.com", "Alice", 1234567890, "D1001");
        User user2 = new User("U1002", "bob@gmail.com", "Bob", 1234567891, "D1002");
        notificationService.addUser(user1);
        notificationService.addUser(user2);

        notificationService.subscribe("U1001", "Email");
        notificationService.subscribe("U1001", "SMS");
        notificationService.subscribe("U1002", "Push");

        notificationService.sendNotificationToUser("U1001", "Welcome to our platform");
        notificationService.sendNotificationToUser("U1002", "Welcome to our platform");

        notificationService.unsubscribe("U1001", "Email");
        notificationService.sendNotification("You have a new message");
        
    }
    
}
