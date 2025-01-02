package models;

import java.util.HashMap;

public class Cart {
    private String id;
    private HashMap<Item, Integer> items;
    private double price;
    private DiscountCode coupon;
    private User user;

    public Cart(String id, double price){
        this.id = id;
        this.items = new HashMap<Item, Integer>();
        this.price = 0;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public HashMap<Item, Integer> getItems(){
        return items;
    }

    public void setItems(HashMap<Item, Integer> items){
        this.items = items;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public DiscountCode getCoupon(){
        return coupon;
    }

    public void setCoupon(DiscountCode coupon){
        this.coupon = coupon;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void addItem(Item item, int quantity){
        if(items.containsKey(item)){
            items.put(item, items.get(item) + quantity);
        } else {
            items.put(item, quantity);
        }
    }

    public void removeItem(Item item, int quantity){
        if(items.containsKey(item)){
            if(items.get(item) > quantity)
                items.put(item, items.get(item) - quantity);

            else if(items.get(item) == quantity)
                items.remove(item);
        }
        else
            System.out.println("Item not found in cart");
    }
}