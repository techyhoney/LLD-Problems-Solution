import java.time.LocalDateTime;
import models.Location;
import models.User;
import models.Locker.*;
import models.LockerLocation;
import models.LockerPackage;
import models.Item;
import enums.LockerStatus;
import java.util.ArrayList;
import java.util.List;

public class AmazonLockerServiceDemo {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazon Locker Service!");
    
        AmazonLockerService amazonLockerService = new AmazonLockerService();
        
        // Create locations
        Location location1 = new Location("12.9716° N", "77.5946° E");  // Bangalore
        Location location2 = new Location("28.7041° N", "77.1025° E");  // Delhi
        
        // Create users
        User user1 = new User(1, "Alice", location1);
        User user2 = new User(2, "Bob", location2);
        
        // Add users to the service
        amazonLockerService.addUser(user1);
        amazonLockerService.addUser(user2);
        
        // Create different types of lockers
        Small smallLocker = new Small(1, true, LockerStatus.AVAILABLE, LocalDateTime.now());
        Large largeLocker = new Large(2, true, LockerStatus.AVAILABLE, LocalDateTime.now());

        System.out.println("\nLocker Sizes:");
        System.out.println("Small Locker Size: " + smallLocker.lockerSize());
        System.out.println("Large Locker Size: " + largeLocker.lockerSize());
        
        // Create locker locations with different types of lockers
        List<Locker> lockersLocation1 = new ArrayList<>();
        lockersLocation1.add(smallLocker);
        LockerLocation lockerLocation1 = new LockerLocation(1, "Bangalore Hub", location1, lockersLocation1);
        
        List<Locker> lockersLocation2 = new ArrayList<>();
        lockersLocation2.add(largeLocker);
        LockerLocation lockerLocation2 = new LockerLocation(2, "Delhi Hub", location2, lockersLocation2);
        
        amazonLockerService.addLocker(smallLocker);
        amazonLockerService.addLocker(largeLocker);
        amazonLockerService.addLockerLocations(lockerLocation1);
        amazonLockerService.addLockerLocations(lockerLocation2);
        
        // Create items for different sized packages
        List<Item> smallItems = new ArrayList<>();
        smallItems.add(new Item(1, "Book"));
        
        List<Item> largeItems = new ArrayList<>();
        largeItems.add(new Item(2, "Large Electronics"));
        
        // Create locker packages
        LockerPackage smallPackage = new LockerPackage(
            1,
            "Small Package",
            user1,
            LocalDateTime.now().plusHours(2),
            smallItems
        );
        
        LockerPackage largePackage = new LockerPackage(
            2,
            "Large Package",
            user2,
            LocalDateTime.now().plusHours(2),
            largeItems
        );
        
        System.out.println("\nTesting Locker Booking Process:");
        
        // Test small package with small locker
        System.out.println("\nTesting Small Locker:");
        System.out.println("Checking if small locker is available: " + 
            amazonLockerService.checkLockerAvailability(smallLocker.getId()));
        
        System.out.println("Booking small locker for Alice...");
        amazonLockerService.bookLocker(user1, smallLocker.getId(), smallPackage);
        
        // Test large package with large locker
        System.out.println("\nTesting Large Locker:");
        System.out.println("Checking if large locker is available: " + 
            amazonLockerService.checkLockerAvailability(largeLocker.getId()));
        
        System.out.println("Booking large locker for Bob...");
        amazonLockerService.bookLocker(user2, largeLocker.getId(), largePackage);
        
        // Simulate OTP validation for small locker
        String smallLockerOTP = smallPackage.getOtp().getContent();
        System.out.println("\nValidating OTP for small locker: " + smallLockerOTP);
        boolean isSmallLockerOTPValid = amazonLockerService.validateOTP(smallLockerOTP, smallPackage);
        System.out.println("Small locker OTP validation result: " + isSmallLockerOTPValid);
        
        // Simulate package pickup
        System.out.println("\nSimulating package pickup from small locker...");
        amazonLockerService.vacateLocker(user1, smallLocker.getId(), smallPackage);
        
        // Verify locker status after pickup
        System.out.println("Checking small locker availability after pickup: " + 
            amazonLockerService.checkLockerAvailability(smallLocker.getId()));
        
        // Test invalid scenarios
        System.out.println("\nTesting Invalid Scenarios:");
        
        // Try to book an already occupied locker
        System.out.println("Attempting to book an occupied large locker...");
        LockerPackage anotherPackage = new LockerPackage(
            3,
            "Another Package",
            user1,
            LocalDateTime.now().plusHours(2),
            smallItems
        );
        amazonLockerService.bookLocker(user1, largeLocker.getId(), anotherPackage);
        
        // Try invalid OTP
        System.out.println("\nTesting invalid OTP:");
        String invalidOTP = "INVALID123";
        System.out.println("Validating invalid OTP: " + invalidOTP);
        boolean isInvalidOTPValid = amazonLockerService.validateOTP(invalidOTP, largePackage);
        System.out.println("Invalid OTP validation result: " + isInvalidOTPValid);
    }
}