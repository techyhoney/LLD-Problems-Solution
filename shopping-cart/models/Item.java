package models;

public class Item {
    private String id;
    private String name;
    private String description;
    private int quantity;
    boolean isAvailable;
    private double price;

    public Item(String id, String name, String description, double price, int quantity, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}