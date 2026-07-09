package org.example.Strategy.Payment;

public class CreditCartPayment implements PaymentStrategy {

    @Override
    public void pay(Double totalFare) {
        System.out.println("Payment of rupees "+ totalFare + " done using Credit Card...");
    }
}
