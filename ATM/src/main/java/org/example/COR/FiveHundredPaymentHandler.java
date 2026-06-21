package org.example.COR;

import org.example.model.ATM;

public class FiveHundredPaymentHandler extends PaymentHandler {

    private PaymentHandler next;

    @Override
    public Boolean canDispense(ATM atm, int amount) {

        int totalNotes = atm.getThousandNotes();
        int notesReq = Math.min((int) amount/500,totalNotes);

        int remainder = amount - notesReq*500;

        return remainder == 0 || (next!=null && next.canDispense(atm,amount-notesReq*500));
    }

    @Override
    public void dispense(ATM atm, int amount) {
        int totalNotes = atm.getThousandNotes();
        int notesReq = Math.min((int) amount/500,totalNotes);
        int remainder = amount - notesReq*500;
        // updating the thousand notes in ATM after withdrawal
        atm.setThousandNotes(totalNotes-notesReq);

        if(notesReq !=0)
            System.out.println("Dispense "+notesReq +"*500 notes");

        if(remainder>0 && next!=null)
            next.dispense(atm,remainder);
    }

    @Override
    public void setNextHandler(PaymentHandler next) {
        this.next = next;
    }
}
