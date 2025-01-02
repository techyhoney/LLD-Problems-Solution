package models;

import java.time.LocalDateTime;
import java.util.List;
import models.Locker.Locker;

public class LockerPackage {

    private int id;
    private String name;
    private Locker assignedLocker;
    private User user;
    private Otp otp;
    private LocalDateTime deliveryTime;
    private List<Item> items;

    public LockerPackage(int id, String name, User user, LocalDateTime deliveryTime, List<Item> items) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.deliveryTime = deliveryTime;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Locker getAssignedLocker() {
        return assignedLocker;
    }

    public Otp getOtp() {
        return otp;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtp(Otp otp) {
        this.otp = otp;
    }

    public void setAssignedLocker(Locker assignedLocker) {
        this.assignedLocker = assignedLocker;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
