package org.example;

import org.example.model.ATM;
import org.example.model.Account;
import org.example.model.Card;
import org.example.service.ATMService;

public class Main {
    public static void main(String[] args) {

        Card card1 = new Card("101","0000",new Account("123489583",5650));
        Card card2 = new Card("102","1111",new Account("988764534",2000));

        ATM atm = new ATM(5,5,10,10);

        ATMService atmService = new ATMService(atm);

        // entering pin without setting card
        //atmService.enterPin("1234");

        atmService.insertCard(card1);
        // without entering pin
        atmService.selectOption();
        // entering wrong pin
        atmService.enterPin("1111");
        // entering right pin
        atmService.enterPin("0000");

        // try to withdrawal without selecting option
        atmService.dispenseCash(4500);

        atmService.selectOption();
        // try to withdrawal incorrect denomination
        atmService.dispenseCash(4510);
        // more than what account balance consist of
        atmService.dispenseCash(6000);

        atmService.dispenseCash(4500);

    }
}