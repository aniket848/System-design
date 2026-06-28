package org.example.Strategy.Payment;

import org.example.Enum.PaymentType;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public PaymentType getPaymentType() {
        return PaymentType.CARD;
    }

    @Override
    public Boolean pay(Double amount) {
        System.out.println("Payment of rupees :"+amount +"has been successful through Card");
        return true;
    }
}
