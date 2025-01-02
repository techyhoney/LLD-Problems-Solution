package VariantGroup;
public abstract class VariantGroup {
    protected int price;

    public VariantGroup(int price) {
        this.price = price;
    }

    public abstract int getPrice();
}
