package org.example.State;

import org.example.Enum.AtmState;
import org.example.model.ATM;
import org.example.model.Card;
import org.example.service.ATMService;

public class CardInsertedATMState implements ATMState{

    private final ATMService atmService;

    public CardInsertedATMState(ATMService atmService){
        this.atmService = atmService;
    }

    @Override
    public ATMState insertCard(Card card) {
        System.out.println("CARD already inserted.");
        return this;
    }

    @Override
    public ATMState insertPin(String pin) {
       Card card = atmService.getCard();
       if(card.getPin().equals(pin)){
           System.out.println("PIN Authenticated...");
           return new AuthenticatedATMState(atmService);
       }
       else{
           System.out.println("PIN is invalid. Please try again..");
           return this;
       }
    }

    @Override
    public ATMState selectOption() {
        System.out.println("Please enter PIN first...");
        return this;
    }

    @Override
    public ATMState withdrawalCash(int amount) {
        System.out.println("Please enter PIN first...");
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
        return AtmState.CARD_ENTERED;
    }
}
