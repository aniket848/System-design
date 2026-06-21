package org.example.State;

import org.example.model.Card;
import org.example.Enum.AtmState;

public interface ATMState {

    public ATMState insertCard(Card card);
    public ATMState insertPin(String pin);
    public ATMState selectOption();
    public ATMState withdrawalCash(int amount);
    public ATMState ejectCard();
    public AtmState getCurrentState();

}
