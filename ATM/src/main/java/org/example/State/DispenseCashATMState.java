package org.example.State;

import org.example.COR.PaymentChainBuilder;
import org.example.COR.PaymentHandler;
import org.example.Enum.AtmState;
import org.example.model.ATM;
import org.example.model.Card;
import org.example.service.ATMService;

public class DispenseCashATMState implements ATMState{

    private final ATMService atmService;
    private final PaymentHandler paymentHandler;

    public DispenseCashATMState(ATMService atmService){
        this.atmService = atmService;
        this.paymentHandler = PaymentChainBuilder.buildChaining();
    }

    @Override
    public ATMState insertCard(Card card) {
        System.out.println("Card already inserted..");
        return this;
    }

    @Override
    public ATMState insertPin(String pin) {
        System.out.println("PIN already authenticated..");
        return this;
    }

    @Override
    public ATMState selectOption() {
        System.out.println("Withdrawal option already selected");
        return this;
    }

    @Override
    public ATMState withdrawalCash(int amount) {
        int totalATMbalance = atmService.getAtm().getTotalCash();
        int totalAccountBalance = atmService.getCard().getAccount().getBalance();

        if(amount > totalATMbalance){
            System.out.println("ATM is short of funds, Can't complete the request");
            return this;
        }

        if(amount > totalAccountBalance){
            System.out.println("Insufficient balance in account!");
            return this;
        }

        ATM atm = atmService.getAtm();

        if(paymentHandler.canDispense(atm,amount)){
            paymentHandler.dispense(atm,amount);
            System.out.println("Total cash withdrawal :"+amount);
            System.out.println("You can remove your card.");
            Card card = atmService.getCard();
            int balanceLeft = card.getAccount().getBalance()-amount;
            card.getAccount().setBalance(balanceLeft);
            System.out.println("Account balance left :"+balanceLeft);
            return ejectCard();
        }
        else{
            System.out.println("Can't able to dispense cash of this denomination.");
            return this;
        }

    }

    @Override
    public ATMState ejectCard() {
        atmService.setCard(null);
        System.out.println("CARD Ejected");
        return new IdleATMState(atmService);
    }

    @Override
    public AtmState getCurrentState() {
        return AtmState.DISPENSE_CASH;
    }
}
