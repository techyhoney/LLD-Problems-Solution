package models.Locker;

import java.time.LocalDateTime;
import enums.LockerStatus;

public class Large extends Locker {
    public Large(int id, boolean isAvailable, LockerStatus status, LocalDateTime bookingTime) {
        super(id, isAvailable, status, bookingTime);
        super.size = 500;
    }
    
    @Override
    public int lockerSize() {
        return size;
    }
}
