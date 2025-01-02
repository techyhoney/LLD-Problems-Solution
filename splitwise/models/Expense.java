package models;
import java.util.List;
import models.split.Split;

public class Expense {

    private int id;
    private double amount;
    private String description;
    private List<Split> splits;
    private User paidBy;

    public Expense(int id, double amount, String description, User paidBy) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }
}