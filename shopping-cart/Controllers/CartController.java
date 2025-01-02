package Controllers;

import models.Cart;
import models.Item;
import models.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CartController{
   private static CartController instance; 
   private final Map<String, Cart> carts;  // Map of cartId to Cart

   private CartController() {
      carts = new ConcurrentHashMap<>();
   }

   public static CartController getInstance() {
      if (instance == null) {
            if(instance == null) {
               synchronized (CartController.class) {
                  instance = new CartController();
               }
            }
      }
      return instance;
   }

   public Cart getCart(String cartId){
      if(!carts.containsKey(cartId)){
         System.out.println("Cart not found");
         return null;
      }
      return carts.get(cartId);
   }

   public void addToCart(User user, String cartId, Item item, int quantity){
      Cart cart = carts.get(cartId);
      if(cart == null){
         cart = new Cart(cartId, 0);
         cart.setUser(user);
         carts.put(cartId, cart);
      }
      cart.addItem(item,quantity);
   }

   public void removeFromCart(String cartId, Item item, int quantity){
      Cart cart = carts.get(cartId);
      if(cart == null){
         System.out.println("Cart not found");
         return;
      }
      cart.removeItem(item,quantity);
   }
}