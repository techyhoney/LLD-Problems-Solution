package interfaces;

import enums.PaymentType;

public class CreditCardStrategy implements PaymentStrategy{
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expiryDate;

    public CreditCardStrategy(String cardNumber, String cardHolderName, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public String getCardDetails(){
        return "Card Number: " + cardNumber + "\nCard Holder Name: " + cardHolderName + "\nExpiry Date: " + expiryDate;
    }

    @Override
    public boolean validatePaymentRequest() {
        if(cardNumber.length() != 16 || cvv.length() != 3 || expiryDate.length() != 5){
            return false;
        }
        return true;
    }
    @Override
    public boolean processPayment(double amount) throws Exception {
        if(!validatePaymentRequest()){
            System.out.println("Invalid Card Details");
            return false;
        }

        try {
            System.out.println("Processing payment with Credit Card");
            System.out.println(getCardDetails());
            System.out.println("Payment Successful");
            return true;
        } catch (Exception e) {
            System.out.println("Payment Failed");
            return false;
        }
    }

    @Override
    public String getPaymentType() {
        return PaymentType.CREDIT_CARD.toString();
    }
}