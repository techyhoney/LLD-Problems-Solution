import java.util.ArrayList;
import java.util.List;

import AddOn.Cheese;
import AddOn.YellowCheese;
import VariantGroup.Large;
import VariantGroup.Small;

public class CatalogService {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(1, "Pizza Palace", "123 Main St");
        Category pizzaCategory = new Category(1, "Pizza");
        Category drinksCategory = new Category(2, "Drinks");

        List<Category> categories = new ArrayList<>();
        categories.add(pizzaCategory);
        categories.add(drinksCategory);
        restaurant.setCategories(categories);

        MenuItem cheezePizza = new MenuItem(1, "Cheese Pizza", pizzaCategory, 100);
        MenuItem pepperoniPizza = new MenuItem(2, "Pepperoni Pizza", pizzaCategory, 150);
        MenuItem coke = new MenuItem(3, "Coke", drinksCategory, 2);
        MenuItem pepsi = new MenuItem(4, "Pepsi", drinksCategory, 2);

        List<MenuItem> PizzaItems = new ArrayList<>();
        List<MenuItem> DrinkItems = new ArrayList<>();
        PizzaItems.add(cheezePizza);
        PizzaItems.add(pepperoniPizza);
        DrinkItems.add(coke);
        DrinkItems.add(pepsi);

        pizzaCategory.setMenuItems(PizzaItems);
        drinksCategory.setMenuItems(DrinkItems);

        IMenuItem order = pepperoniPizza;
        order = new VariantGroupDecorator(order, new Large());
        order = new AddOnDecorator(order, new Cheese());

        System.out.println("Order: " + order.getDescription());
        System.out.println("Price: " + order.getCost());

        IMenuItem order2 = cheezePizza;
        order2 = new VariantGroupDecorator(order2, new Small());
        order2 = new AddOnDecorator(order2, new YellowCheese());

        System.out.println("Order: " + order2.getDescription());
        System.out.println("Price: " + order2.getCost());

    }
}
