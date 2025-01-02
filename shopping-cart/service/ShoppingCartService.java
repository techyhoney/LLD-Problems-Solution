package service;

import java.util.HashMap;
import java.util.Map;

import Controllers.CartController;
import models.Cart;
import models.DiscountCode;
import models.Item;
import models.User;

public class ShoppingCartService {
    private static ShoppingCartService instance;
    private final CartController cartController;
    HashMap<String, Item> items = new HashMap<>();
    HashMap<String, User> users = new HashMap<>();
    HashMap<String, DiscountCode> discountCodes = new HashMap<>();
    
    private ShoppingCartService() {
        cartController = CartController.getInstance();
    }

    public static ShoppingCartService getInstance() {
        if (instance == null) {
            if(instance == null) {
                synchronized (ShoppingCartService.class) {
                    instance = new ShoppingCartService();
                }
            }
        }
        return instance;
    }

    public void addItem(Item item) {
        items.put(item.getId(),item);
    }

    public void addUser(User user) {
        users.put(user.getId(),user);
    }

    public void addDiscountCode(DiscountCode discountCode) {
        discountCodes.put(discountCode.getId(),discountCode);
    }

    public boolean checkProductAvailability(Item item, int quantity) {
        if(!item.getIsAvailable()){
            System.out.println("Item not found");
            return false;
        }
        if(item.getQuantity() < quantity){
            System.out.println("Quantity not available");
            return false;
        }
        return true;
    }

    public void addProductToCart(String userId, String cartId, Item item,int quantity) {
        if(!checkProductAvailability(item, quantity)){
            return;
        }
        User user = users.get(userId);
        cartController.addToCart(user, cartId, item, quantity);
        updateProductQuantity(item, -1*quantity);
    }

    public void removeProductFromCart(String cartId, Item item,int quantity) {
        cartController.removeFromCart(cartId, item, quantity);
        updateProductQuantity(item, quantity);
    }

    public void updateProductQuantity(Item item,int quantity) {
        if(items.containsKey(item.getId())){
            item.setQuantity(item.getQuantity() + quantity);
            if(item.getQuantity() == 0){
                item.setIsAvailable(false);
                items.remove(item.getId());
            }
            else{
                item.setIsAvailable(true);
                items.put(item.getId(),item);
            }
        }
    }

    public void applyDiscountCode(String cartId, String discountCodeId) {
        Cart cart =cartController.getCart(cartId);
        if(cart==null){
            return;
        }
        DiscountCode code = discountCodes.get(discountCodeId);
        cart.setCoupon(code);
        calculateTotalPrice(cartId);
    }

    public void removeDiscountCode(String cartId){
        Cart cart = cartController.getCart(cartId);
        if(cart==null){
            return;
        }
        cart.setCoupon(null);
        calculateTotalPrice(cartId);
    }

    public void calculateTotalPrice(String cartId) {
        Cart cart = cartController.getCart(cartId);
        if(cart==null){
            return;
        }

        double totalPrice = 0;
        for(Map.Entry<Item, Integer> entry : cart.getItems().entrySet()){
            Item item = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += item.getPrice() * quantity;
        }
        if(cart.getCoupon()!=null){
            totalPrice = cart.getCoupon().calculateDiscountPrice(totalPrice);
        }
        cart.setPrice(totalPrice);
    }

    public double getTotalPrice(String cartId) {
        Cart cart = cartController.getCart(cartId);
        if(cart==null){
            return 0;
        }
        return cart.getPrice();
    }

    public void printCartDetails(String cartId) {
        Cart cart = cartController.getCart(cartId);
        if(cart==null){
            return;
        }
        System.out.println("Cart Id: " + cart.getId());
        System.out.println("User Id: " + cart.getUser().getId());
        System.out.println("Items in Cart: ");
        for(Map.Entry<Item, Integer> entry : cart.getItems().entrySet()){
            Item item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Item Id: " + item.getId() + " Item Name: " + item.getName() + " Quantity: " + quantity);
        }
        System.out.println("Total Price: " + cart.getPrice());
    }
    
}