package org.example.Strategy.Payment;

import org.example.Enum.PaymentType;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public PaymentType getPaymentType() {
        return PaymentType.UPI;
    }

    @Override
    public Boolean pay(Double amount) {
        System.out.println("Payment of rupees :"+amount +"has been successful through UPI");
        return true;
    }
}
