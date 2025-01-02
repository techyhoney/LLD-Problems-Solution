package interfaces;

public class FlatDiscount implements DiscountStrategy {
    private double discount;

    public FlatDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateDiscountPrice(double price) {
        return price - discount;
    }
}
