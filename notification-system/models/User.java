package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    String id;
    String email;
    String name;
    int phone;
    String deviceId;
    List<String> activeNotificationTypes;

    public User(String id, String email, String name, int phone, String deviceId) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.deviceId = deviceId;
        this.activeNotificationTypes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<String> getActiveNotificationTypes() {
        return activeNotificationTypes;
    }

    public void addNotificationType(String type) {
        activeNotificationTypes.add(type);
    }

    public void removeNotificationType(String type) {
        activeNotificationTypes.remove(type);
    }

}
