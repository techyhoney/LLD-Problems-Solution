import java.util.List;
import AddOn.AddOn;
import VariantGroup.VariantGroup;

public class MenuItem implements IMenuItem {
    private int id;
    private String name;
    private Category category;
    private int price;
    private List<VariantGroup> groups;
    private List<AddOn> addons;

    public MenuItem(int id, String name, Category category, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public List<VariantGroup> getGroups() {
        return groups;
    }

    public List<AddOn> getAddons() {
        return addons;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setGroups(List<VariantGroup> groups) {
        this.groups = groups;
    }

    public void setAddons(List<AddOn> addons) {
        this.addons = addons;
    }

    @Override
    public int getCost() {
        return price;
    }

    @Override
    public String getDescription() {
        return name;
    }

}
