import interfaces.CreditCardStrategy;
import interfaces.PaymentStrategy;
import interfaces.UpiStrategy;
import models.Payment;

public class PaymentServiceDemo {
    public static void run(){
        System.out.println("Payment Service Demo");
        Payment payment = new Payment(2000.0);
        PaymentStrategy creditCardStrategy = new CreditCardStrategy("1234567890123456", "John Nick" , "123", "12/24");
        payment.setPaymentStrategy(creditCardStrategy);
        System.out.println("Payment ID: " + payment.getId());
        try {
            payment.processPayment();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PaymentStrategy UpiStrategy = new UpiStrategy("john@oksbi");
        payment.setPaymentStrategy(UpiStrategy);
        try {
            payment.processPayment();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
