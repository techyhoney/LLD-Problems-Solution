package models;

import java.util.List;

import models.Locker.Locker;

public class LockerLocation {

    private int id;
    private String name;
    private Location location;
    private List<Locker> lockers;

    public LockerLocation(int id, String name, Location location, List<Locker> lockers) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.lockers = lockers;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public List<Locker> getLockers() {
        return lockers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLockers(List<Locker> lockers) {
        this.lockers = lockers;
    }

}
