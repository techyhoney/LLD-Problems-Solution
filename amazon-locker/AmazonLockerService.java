import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import enums.LockerStatus;
import models.Locker.Locker;
import models.LockerLocation;
import models.LockerPackage;
import models.NotificationService;
import models.Notification;
import models.Otp;
import models.User;

public class AmazonLockerService {
    Map<Integer, Locker> lockers;
    Map<Integer, User> users;
    Map<Integer, LockerLocation> lockerLocations;
    NotificationService notificationService;

    public AmazonLockerService() {
        // Initialize the system
        this.lockers = new HashMap<>();
        this.users = new HashMap<>();
        this.lockerLocations = new HashMap<>();
        notificationService = new NotificationService();
    }
    public void addLockerLocations(LockerLocation lockerLocation) {
        // Add locker locations to the system
        lockerLocations.put(lockerLocation.getId(), lockerLocation);
    }

    public void addLocker(Locker locker) {
        // Add a locker to the system
        lockers.put(locker.getId(), locker);
    }

    public void addUser(User user) {
        // Add a user to the system
        users.put(user.getId(), user);
    }

    public boolean checkLockerAvailability(int lockerId) {
        // Check if a locker is available
        return lockers.get(lockerId).isAvailable();
    }

    public Locker getNearestLocker() {
        // Get the nearest locker
        return null;
    }

    public String generateOTP(){
        return "A" + Math.random() + "ZY";
    }

    public void sendOTP(User user, LockerPackage lockerPackage) {
        // Send an OTP
        Otp otp = new Otp(1, generateOTP(), LocalDateTime.now().plusDays(3), lockerPackage);
        lockerPackage.setOtp(otp);
        Notification notification = new Notification((int)Math.random(), otp.toString());
        notificationService.sendNotification(notification, user);
        return;
    }


    public boolean validateOTP(String enteredOtp, LockerPackage lockerPackage) {
        // Validate the OTP
        Otp otp = lockerPackage.getOtp();
        if(otp.getContent().equals(enteredOtp) && otp.checkOTPValidity()){
            return true;
        }
        return false;
    }

    public void bookLocker(User user, int lockerId, LockerPackage lockerPackage) {
        // Book a locker
        if(checkLockerAvailability(lockerId)){
            Locker locker = lockers.get(lockerId);
            locker.setStatus(LockerStatus.BOOKED);
            lockerPackage.setAssignedLocker(locker);
            user.setLockerPackage(lockerPackage);
            sendOTP(user, lockerPackage);
        }
        else
            return;
    }

    public void vacateLocker(User user, int lockerId, LockerPackage lockerPackage) {
        // Vacate a locker
        Locker locker = lockers.get(lockerId);
        locker.setStatus(LockerStatus.AVAILABLE);
        lockerPackage.setAssignedLocker(null);
        user.setLockerPackage(null);
        Notification notification = new Notification((int)Math.random(), "Locker vacated successfully");
        notificationService.sendNotification(notification, user);
    }
}
