package models;

public class Account{
    private String name;
    private String accountNo;
    private double balance;

    public Account(String name, String accountNo, double balance){
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getName(){
        return name;
    }

    public String getAccountNo(){
        return accountNo;
    }

    public double getBalance(){
        return balance;
    }


    public void debitAmount(double amount){
        if(amount > balance){
            System.out.println("Insufficient balance");
        }
        else{
            balance -= amount;
        }
    }

    public void creditAmount(double amount){
        balance += amount;
    }
}
