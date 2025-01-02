package models.split;

import models.User;

public class EqualSplit extends Split {
    public EqualSplit(User user) {
        super(user);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}