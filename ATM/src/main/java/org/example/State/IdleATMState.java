package org.example.State;

import org.example.Enum.AtmState;
import org.example.model.Card;
import org.example.service.ATMService;

public class IdleATMState implements ATMState{

    private final ATMService atmService;

    public IdleATMState(ATMService atmService){
        this.atmService = atmService;
    }

    @Override
    public ATMState insertCard(Card card) {
        atmService.setCard(card);
        System.out.println("CARD Inserted...");
        return new CardInsertedATMState(atmService);
    }

    @Override
    public ATMState insertPin(String pin) {
        System.out.println("Card not inserted");
        return this;
    }

    @Override
    public ATMState selectOption() {
        System.out.println("Card not inserted");
        return this;
    }

    @Override
    public ATMState withdrawalCash(int amount) {
        System.out.println("Card not inserted");
        return this;
    }

    @Override
    public ATMState ejectCard() {
        System.out.println("Card not inserted");
        return this;
    }

    @Override
    public AtmState getCurrentState() {
        return AtmState.IDLE;
    }
}
