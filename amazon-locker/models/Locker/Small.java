package models.Locker;

import java.time.LocalDateTime;

import enums.LockerStatus;

// public class Small extends Locker{
//     public Small(){
//         super(500);
//     }

//     @Override
//     public int lockerSize(){
//         return size;
//     }
// }


public class Small extends Locker {
    public Small(int id, boolean isAvailable, LockerStatus status, LocalDateTime bookingTime) {
        super(id, isAvailable, status, bookingTime);
        super.size = 500;
    }
    
    @Override
    public int lockerSize() {
        return size;
    }
}