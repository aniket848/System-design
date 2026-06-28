package org.example.Factory;

import org.example.Enum.PaymentType;
import org.example.Strategy.Payment.CardPaymentStrategy;
import org.example.Strategy.Payment.PaymentStrategy;
import org.example.Strategy.Payment.UPIPaymentStrategy;

public class PaymentFactory {

    public static PaymentStrategy createPayment(PaymentType paymentType){

        return switch(paymentType){
            case UPI -> new UPIPaymentStrategy();
            case CARD -> new CardPaymentStrategy();
            default -> null;
        };
    }
}
