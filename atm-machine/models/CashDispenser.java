package models;

public class CashDispenser{
    private int availableCash;

    public CashDispenser(int availableCash){
        this.availableCash = availableCash;
    }

    public void dispenseCash(int amount){
        if(amount > availableCash){
            System.out.println("Insufficient cash in the ATM");
        }
        else{
            availableCash -= amount;
        }
    }
    
}