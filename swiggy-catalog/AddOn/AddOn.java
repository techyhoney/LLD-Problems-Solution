package AddOn;

public abstract class AddOn {
    protected int price;

    public AddOn(int price) {
        this.price = price;
    }

    public abstract int getPrice();
}
