package models.Transaction;

import models.Account;

public class Deposit extends Transaction{
    public Deposit(String transactionId, Account account, double amount){
        super(transactionId, account, amount);
    }
    
    @Override
    public void processTransaction(Account account,double amount){
        account.creditAmount(amount);
    }
}