package org.example.Strategy.Payment;

import org.example.Enum.PaymentType;

public interface PaymentStrategy {

    public PaymentType getPaymentType();
    public Boolean pay(Double amount);
}
