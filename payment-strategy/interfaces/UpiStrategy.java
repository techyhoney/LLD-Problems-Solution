package interfaces;

import enums.PaymentType;

public class UpiStrategy implements PaymentStrategy{
    String upiId;

    public UpiStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean validatePaymentRequest() {
        if(upiId==null || !upiId.contains("@")){
            return false;
        }
        return true;
    }

    @Override
    public boolean processPayment(double amount) throws Exception {
        if(!validatePaymentRequest()){
            System.out.println("Invalid UPI Details");
            return false;
        }

        try {
            System.out.println("Processing payment with UPI " + upiId);
            System.out.println("Payment Successful");
            return true;
        } catch (Exception e) {
            System.out.println("Payment Failed");
            return false;
        }
    }

    @Override
    public String getPaymentType() {
        return PaymentType.UPI.toString();
    }
}