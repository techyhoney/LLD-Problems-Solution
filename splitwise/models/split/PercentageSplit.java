package models.split;

import models.User;

public class PercentageSplit extends Split {
    private double percentage;

    public PercentageSplit(User user, double percentage) {
        super(user);
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double getAmount() {
        return amount * percentage / 100;
    }
}