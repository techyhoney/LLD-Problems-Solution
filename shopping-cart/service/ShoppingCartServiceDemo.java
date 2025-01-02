package service;

import interfaces.FlatDiscount;
import interfaces.PercentDiscount;
import models.DiscountCode;
import models.Item;
import models.User;

public class ShoppingCartServiceDemo{
    public static void run() {
        ShoppingCartService shoppingCartService = ShoppingCartService.getInstance();

        User user1 = new User("User1001", "Alice", "alice@gmail.com");
        User user2 = new User("User1002", "Bob", "bob@gmail.com");
        shoppingCartService.addUser(user1);
        shoppingCartService.addUser(user2);
        
        Item item1 = new Item("Item1001", "Laptop", "Dell Laptop", 1000, 10, true);
        Item item2 = new Item("Item1002", "Mobile", "Samsung Mobile", 500, 20, true);
        shoppingCartService.addItem(item1);
        shoppingCartService.addItem(item2);

        DiscountCode discountCode1 = new DiscountCode("Discount1001", "FLAT100");
        discountCode1.setDiscountStrategy(new FlatDiscount(100));
        DiscountCode discountCode2 = new DiscountCode("Discount200", "FLAT200");
        discountCode2.setDiscountStrategy(new FlatDiscount(200));
        DiscountCode discountCode3 = new DiscountCode("Discount1010", "PERCENT10");
        discountCode3.setDiscountStrategy(new PercentDiscount(10));

        shoppingCartService.addDiscountCode(discountCode1);
        shoppingCartService.addDiscountCode(discountCode2);
        shoppingCartService.addDiscountCode(discountCode3);

        shoppingCartService.addProductToCart("User1001", "Cart1001", item1, 2);     
        shoppingCartService.addProductToCart("User1001", "Cart1001", item2, 3);
        shoppingCartService.calculateTotalPrice("Cart1001");
        System.out.println("Total Price: " + shoppingCartService.getTotalPrice("Cart1001"));

        shoppingCartService.applyDiscountCode("Cart1001", discountCode3.getId());
        System.out.println("Total Price after discount: " + shoppingCartService.getTotalPrice("Cart1001"));
        
        shoppingCartService.removeProductFromCart("Cart1001", item1, 1);
        shoppingCartService.calculateTotalPrice("Cart1001");
        System.out.println("Total Price after removing item: " + shoppingCartService.getTotalPrice("Cart1001"));

        shoppingCartService.printCartDetails("Cart1001");
        
        shoppingCartService.removeDiscountCode("Cart1001");
        System.out.println("Total Price after removing discount: " + shoppingCartService.getTotalPrice("Cart1001"));

    }
}