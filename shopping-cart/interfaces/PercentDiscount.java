package interfaces;

public class PercentDiscount implements DiscountStrategy {
    private double percent;

    public PercentDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double calculateDiscountPrice(double price) {
        return price - (price * percent / 100);
    }   
    
}
