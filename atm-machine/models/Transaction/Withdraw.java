package models.Transaction;

import models.Account;

public class Withdraw extends Transaction {
    public Withdraw(String transactionId, Account account,double amount){
        super(transactionId, account,amount);
    }

    @Override
    public void processTransaction(Account account, double amount) {
        account.debitAmount(amount);
    }
}