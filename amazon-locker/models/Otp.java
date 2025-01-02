package models;

import java.time.LocalDateTime;

public class Otp {
    private int id;
    private String content;
    private LocalDateTime expiry;
    private LockerPackage lockerPackage;

    public Otp(int id, String content, LocalDateTime expiry, LockerPackage lockerPackage) {
        this.id = id;
        this.content = content;
        this.expiry = expiry;
        this.lockerPackage = lockerPackage;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getExpiry() {
        return expiry;
    }

    public LockerPackage getLockerPackage() {
        return lockerPackage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setExpiry(LocalDateTime expiry) {
        this.expiry = expiry;
    }

    public void setLockerPackage(LockerPackage lockerPackage) {
        this.lockerPackage = lockerPackage;
    }
    
    public boolean checkOTPValidity(){
        if(LocalDateTime.now().isBefore(expiry)){
            return true;
        }
        return false;
    }

    public String toString(){
        return "OTP: " + content + " Expiry: " + expiry;
    }
}
