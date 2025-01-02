package interfaces;

public interface PaymentStrategy {
    boolean processPayment(double amount) throws Exception;
    boolean validatePaymentRequest();
    String getPaymentType();
}