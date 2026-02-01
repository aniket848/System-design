abstract class moneyHandler{

    protected moneyHandler nextHandler;

    public moneyHandler(){
        this.nextHandler = null;
    }

    public void setNextHandler(moneyHandler handler){
        this.nextHandler = handler;
    }

    public abstract void dispense(int amount);

}

class ThousandRuppeHandler extends moneyHandler{

    private int numNotes;

    public ThousandRuppeHandler(int numNotes){
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int reqNotes = amount/1000;

        if(reqNotes > numNotes){
            System.out.println("Dispensing "+ numNotes +" *1000 rupee");
            int remainingAmount = amount - (numNotes * 1000);
            numNotes = 0;
            nextHandler.dispense(remainingAmount);
        }
        else{
            if(reqNotes !=0)
              System.out.println("Dispensing "+ reqNotes +" *1000 rupee");
            if(amount % 1000 != 0 && nextHandler != null){
                numNotes -= reqNotes;
                nextHandler.dispense(amount-1000*reqNotes);
            }
            else if(amount % 1000 != 0 && nextHandler == null){
                System.out.println("Sorry! Cannot dispense the exact amount with available denominations.");
            }
        }
    }
}

class FiveHunderedRuppeHandler extends moneyHandler{

    private int numNotes;

    public FiveHunderedRuppeHandler(int numNotes){
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int reqNotes = amount/500;

        if(reqNotes > numNotes){
            System.out.println("Dispensing "+ numNotes +" *500 rupee");
            int remainingAmount = amount - (numNotes * 500);
            numNotes = 0;
            nextHandler.dispense(remainingAmount);
        }
        else{
            if(reqNotes !=0)
               System.out.println("Dispensing "+ reqNotes +" *500 rupee");
            if(amount % 500 != 0 && nextHandler != null){
                numNotes -= reqNotes;
                nextHandler.dispense(amount-500*reqNotes);
            }
            else if(amount % 500 != 0 && nextHandler == null){
                System.out.println("Sorry! Cannot dispense the exact amount with available denominations.");
            }

        }
    }
}

class HunderedRuppeHandler extends moneyHandler{

    private int numNotes;

    public HunderedRuppeHandler(int numNotes){
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int reqNotes = amount/100;

        if(reqNotes > numNotes){
            System.out.println("Dispensing "+ numNotes +" *100 rupee");
            int remainingAmount = amount - (numNotes * 100);
            numNotes = 0;
            nextHandler.dispense(remainingAmount);
        }
        else{
            if(reqNotes !=0)
                System.out.println("Dispensing "+ reqNotes +" *100 rupee");
            if(amount % 100 != 0 && nextHandler != null){
                numNotes -= reqNotes;
                nextHandler.dispense(amount-100*reqNotes);
            }
            else if(amount % 100 != 0 && nextHandler == null){
                System.out.println("Sorry! Cannot dispense the exact amount with available denominations.");
            }
        }
    }
}

class TwentyRuppeHandler extends moneyHandler{

    private int numNotes;

    public TwentyRuppeHandler(int numNotes){
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int reqNotes = amount/20;

        if(reqNotes > numNotes){
            if(numNotes !=0)
               System.out.println("Dispensing "+ numNotes +" *20 rupee");
            int remainingAmount = amount - (numNotes * 20);
            numNotes = 0;
            nextHandler.dispense(remainingAmount);
        }
        else{
            if(reqNotes !=0)
                System.out.println("Dispensing "+ reqNotes +" *20 rupee");
            if(amount % 20 != 0 && nextHandler != null){
                numNotes -= reqNotes;
                nextHandler.dispense(amount-20*reqNotes);
            }
            else if(amount % 20 != 0 && nextHandler == null){
                System.out.println("Sorry! Cannot dispense the exact amount with available denominations.");
            }
        }
    }
}

class TenRuppeHandler extends moneyHandler{

    private int numNotes;

    public TenRuppeHandler(int numNotes){
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int reqNotes = amount/10;

        if(reqNotes > numNotes){
            System.out.println("Dispensing "+ numNotes +" *10 rupee");
            int remainingAmount = amount - (numNotes * 10);
            numNotes = 0;
            nextHandler.dispense(remainingAmount);
        }
        else{
            if(reqNotes !=0)
               System.out.println("Dispensing "+ reqNotes +" *10 rupee");
            if(amount % 10 != 0 && nextHandler != null){
                numNotes -= reqNotes;
                nextHandler.dispense(amount-10*reqNotes);
            }
            else if(amount % 10 != 0 && nextHandler == null){
                System.out.println("Sorry! Cannot dispense the exact amount with available denominations.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        moneyHandler thousandRuppeHandler = new ThousandRuppeHandler(3);
        moneyHandler fiveHunderedRuppeHandler = new FiveHunderedRuppeHandler(20);
        moneyHandler hunderedRuppeHandler = new HunderedRuppeHandler(100);
        moneyHandler twentyRuppeHandler = new TwentyRuppeHandler(2);
        moneyHandler tenRuppeHandler = new TenRuppeHandler(100);

        thousandRuppeHandler.setNextHandler(fiveHunderedRuppeHandler);
        fiveHunderedRuppeHandler.setNextHandler(hunderedRuppeHandler);
        hunderedRuppeHandler.setNextHandler(twentyRuppeHandler);
        twentyRuppeHandler.setNextHandler(tenRuppeHandler);

        int amount = 5650;

        thousandRuppeHandler.dispense(amount);

        System.out.println("\nRequesting another amount: of 530\n");

        thousandRuppeHandler.dispense(530);
    }
}