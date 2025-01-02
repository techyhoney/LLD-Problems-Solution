package models;

import enums.PaymentStatus;
import interfaces.PaymentStrategy;

public class Payment {
    private String id;
    private Double totalAmount;
    private PaymentStatus status;
    private PaymentStrategy paymentStrategy;

    public Payment(Double totalAmount) {
        this.id = "PAY_" + System.currentTimeMillis();
        this.totalAmount = totalAmount;
        this.status = PaymentStatus.PENDING;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public String getId() {
        return id;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() throws InterruptedException {
        if (paymentStrategy == null) {
            System.out.println("Payment Strategy not set");
            return;
        }
        if (status == PaymentStatus.PENDING || status == PaymentStatus.FAILED) {
            try{
                status = paymentStrategy.processPayment(totalAmount) ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        else {
            System.out.println("Payment id: " + id + " has been already done..");
        }
    }
}
