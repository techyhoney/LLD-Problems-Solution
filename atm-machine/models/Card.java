package models;

import java.time.LocalDateTime;

public class Card{
    private String cardNumber;
    private LocalDateTime expiryDate;
    private int pin;
    private Account account;

    public Card(String cardNumber, LocalDateTime expiryDate, int pin){
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.pin = pin;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public LocalDateTime getExpiryDate(){
        return expiryDate;
    }

    public int getPin(){
        return pin;
    }

    public Account getAccount(){
        return account;
    }

    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public void setExpiryDate(LocalDateTime expiryDate){
        this.expiryDate = expiryDate;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public void setAccount(Account account){
        this.account = account;
    }
}