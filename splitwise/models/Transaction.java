package models;

import enums.TransactionStatus;

public class Transaction{
    private String id;
    private User sender;
    private User receiver;
    private TransactionStatus status;
    private double amount;

    public Transaction(String id, User sender, User receiver, TransactionStatus status, double amount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }   
    public User getSender() {
        return sender;
    }
    public User getReceiver() {
        return receiver;
    }
    public TransactionStatus getStatus() {
        return status;
    }
    public double getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

}