package org.example.service;

import org.example.State.ATMState;
import org.example.State.IdleATMState;
import org.example.model.ATM;
import org.example.model.Card;

public class ATMService {

    private ATMState currentState;
    private ATM atm;
    private Card card;

    public ATMService(ATM atm){
      this.atm = atm;
      this.currentState = new IdleATMState(this);
    }

    public void insertCard(Card card){
        currentState = currentState.insertCard(card);
    }

    public void enterPin(String pin){
        currentState = currentState.insertPin(pin);
    }

    public void selectOption(){
        currentState = currentState.selectOption();
    }

    public void dispenseCash(int amount){
        currentState = currentState.withdrawalCash(amount);
    }

    public void setCard(Card card){
        this.card = card;
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public ATM getAtm() {
        return atm;
    }

    public Card getCard() {
        return card;
    }
}
