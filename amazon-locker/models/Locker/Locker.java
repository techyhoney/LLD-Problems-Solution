package models.Locker;

import java.time.LocalDateTime;
import enums.LockerStatus;

public abstract class Locker {
    private int id;
    private boolean isAvailable;
    private LockerStatus status;
    private LocalDateTime bookingTime;
    protected int size;

    public Locker(int size) {
        this.size = size;
    }

    public Locker(int id, boolean isAvailable, LockerStatus status, LocalDateTime bookingTime) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.status = status;
        this.bookingTime = bookingTime;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public LockerStatus getStatus() {
        return status;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public int getSize() {
        return size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setStatus(LockerStatus status) {
        this.status = status;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public abstract int lockerSize();

}
