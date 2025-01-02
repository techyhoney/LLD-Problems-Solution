package models.Transaction;

import java.time.LocalDate;

import enums.TransactionStatus;
import models.Account;

public abstract class Transaction{
    private String transactionId;
    private Account account;
    private double amount;
    private LocalDate date;
    TransactionStatus status;
    
    public Transaction(String transactionId, Account account, double amount){
        this.transactionId = transactionId;
        this.account = account;
        this.amount = amount;
    }

    public String getTransactionId(){
        return transactionId;
    }

    public Account getAccount(){
        return account;
    }

    public double getAmount(){
        return amount;
    }

    public LocalDate getDate(){
        return date;
    }

    public TransactionStatus getStatus(){
        return status;
    }

    public void setTransactionId(String transactionId){
        this.transactionId = transactionId;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setStatus(TransactionStatus status){
        this.status = status;
    }

    public abstract void processTransaction(Account account, double amount);
    
}