package org.example.model;

public class ATM {

    private int id;
    private int totalCash;

    private int thousandNotes;
    private int fiveHundredNotes;
    private int hundredNotes;

    public ATM(int id, int thousandNotes, int fiveHundredNotes, int hundredNotes){
        this.id = id;
        this.totalCash = 1000*thousandNotes + 500*fiveHundredNotes + 100*hundredNotes;
        this.thousandNotes = thousandNotes;
        this.fiveHundredNotes = fiveHundredNotes;
        this.hundredNotes = hundredNotes;
    }

    public int getId() {
        return id;
    }

    public int getTotalCash() {
        return totalCash;
    }

    public int getThousandNotes() {
        return thousandNotes;
    }

    public int getFiveHundredNotes() {
        return fiveHundredNotes;
    }

    public int getHundredNotes() {
        return hundredNotes;
    }

    public void setTotalCash(int totalCash) {
        this.totalCash = totalCash;
    }

    public void setThousandNotes(int thousandNotes) {
        this.thousandNotes = thousandNotes;
    }

    public void setFiveHundredNotes(int fiveHundredNotes) {
        this.fiveHundredNotes = fiveHundredNotes;
    }

    public void setHundredNotes(int hundredNotes) {
        this.hundredNotes = hundredNotes;
    }
}
