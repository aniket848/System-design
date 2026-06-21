package org.example.State;

import org.example.Enum.AtmState;
import org.example.model.Card;
import org.example.service.ATMService;

public class AuthenticatedATMState implements ATMState{

    private final ATMService atmService;

    public AuthenticatedATMState(ATMService atmService)
    {
        this.atmService = atmService;
    }

    @Override
    public ATMState insertCard(Card card) {
        System.out.println("Card already inserted..");
        return this;
    }

    @Override
    public ATMState insertPin(String pin) {
        System.out.println("PIN already authenticated");
        return this;
    }

    @Override
    public ATMState selectOption() {
       // here we can select multiple option, but for now, selecting withdrawal option
        System.out.println("Withdrawal Option selected..");
        return new DispenseCashATMState(atmService);
    }

    @Override
    public ATMState withdrawalCash(int amount) {
        System.out.println("Please select option first..,");
        return this;
    }

    @Override
    public ATMState ejectCard() {
        atmService.setCard(null);
        System.out.println("CARD Ejected");
        return new IdleATMState(atmService);
    }

    @Override
    public AtmState getCurrentState() {
        return AtmState.AUTHENTICATED;
    }
}
