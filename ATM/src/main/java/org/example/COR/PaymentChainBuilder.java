package org.example.COR;

public class PaymentChainBuilder {

    public static PaymentHandler buildChaining(){
        PaymentHandler thousandPaymentHandler = new ThousandPaymentHandler();
        PaymentHandler fiveHundredPaymentHandler = new FiveHundredPaymentHandler();
        PaymentHandler HundredPaymentHandler = new HundredPaymentHandler();

        thousandPaymentHandler.setNextHandler(fiveHundredPaymentHandler);
        fiveHundredPaymentHandler.setNextHandler(HundredPaymentHandler);

        return thousandPaymentHandler;
    }
}
