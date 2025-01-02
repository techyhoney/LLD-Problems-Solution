package models;

public class User {
    int id;
    String name;
    Location location;
    private LockerPackage lockerPackage;
    
    public User(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public User(int id, String name, Location location, LockerPackage lockerPackage) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.lockerPackage=lockerPackage;
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

    public LockerPackage getLockerPackage() {
        return lockerPackage;
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

    public void setLockerPackage(LockerPackage lockerPackage) {
        this.lockerPackage = lockerPackage;
    }

    
    
}
