package org.example.COR;

import org.example.model.ATM;

public abstract class PaymentHandler {


    public abstract Boolean canDispense(ATM atm,int amount);
    public abstract void dispense(ATM atm,int amount);
    public abstract void setNextHandler(PaymentHandler next);
}
