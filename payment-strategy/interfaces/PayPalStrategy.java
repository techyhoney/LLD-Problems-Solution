package interfaces;

import enums.PaymentType;

public class PayPalStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
            return email;
    }

    @Override
    public boolean validatePaymentRequest() {
        if(email==null || password==null || !email.contains("@")){
            return false;
        }
        return true;
    }

    @Override
    public boolean processPayment(double amount) throws Exception {
        if(!validatePaymentRequest()){
            System.out.println("Invalid PayPal Details");
            return false;
        }

        try {
            System.out.println("Processing payment with PayPal " + email);
            System.out.println("Payment Successful");
            return true;
        } catch (Exception e) {
            System.out.println("Payment Failed");
            return false;
        }
    }

    @Override
    public String getPaymentType() {
        return PaymentType.PAYPAL.toString();
    }
    
}