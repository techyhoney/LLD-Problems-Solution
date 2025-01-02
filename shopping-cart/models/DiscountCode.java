package models;

import interfaces.DiscountStrategy;

public class DiscountCode {
    String id;
    String code;
    DiscountStrategy discountStrategy;

    public DiscountCode(String id, String code) {
        this.id = id;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscountPrice(double price) {
        return discountStrategy.calculateDiscountPrice(price);
    }
}
