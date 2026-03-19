interface State{
    public State insertCoin(VendingMachine machine, Integer coin);
    public State selectItem(VendingMachine machine);
    public State dispense(VendingMachine machine);
    public State refill(VendingMachine machine, Integer quantity);
    public String getStateName();
}

class VendingMachine{
    private Integer totalQuantity;
    private Integer pricePerItem;
    private Integer insertedCoins;
    private State currentState;

    private State noCoinState;
    private State hasCoinState;
    private State dispenseState;
    private State soldOutState;

    public VendingMachine(Integer totalQuantity, Integer price) {
        this.totalQuantity = totalQuantity;
        this.pricePerItem = price;
        this.insertedCoins = 0;

        noCoinState = new NoCoinState();
        hasCoinState = new HasCoinState();
        dispenseState = new DispenseState();
        soldOutState = new SoldOutState();

        if(totalQuantity > 0){
            currentState = noCoinState;
        }
        else{
            currentState = soldOutState;
        }
    }

    public void addCoin(Integer coin){
        insertedCoins+= coin;
        System.out.println("Total inserted coins: "+insertedCoins);
    }

    public Integer getInsertedCoins(){
        return insertedCoins;
    }

    public void setInsertedCoins(Integer coins){ insertedCoins = coins; }

    public void decItem(){
        totalQuantity--;
    }

    public void incItem(){
        totalQuantity++;
    }

    public void incItem(Integer quantity){
        totalQuantity+= quantity;
    }

    public Integer getTotalQuantity(){
        return totalQuantity;
    }

    public Integer getPricePerItem(){
        return pricePerItem;
    }

    public State getNoCoinState(){
        return noCoinState;
    }

    public State getHasCoinState(){
        return hasCoinState;
    }

    public State getDispenseState(){
        return dispenseState;
    }

    public State getSoldOutState(){
        return soldOutState;
    }

    public void insertCoin(Integer coin){
        currentState = currentState.insertCoin(this,coin);
    }

    public void selectItem(){
        currentState = currentState.selectItem(this);
    }

    public void dispense(){
        currentState = currentState.dispense(this);
    }

    public void refill(Integer quantity){
        currentState = currentState.refill(this,quantity);
    }

    public String getCurrentStateName(){
        return currentState.getStateName();
    }

}

class NoCoinState implements State{

    @Override
    public State insertCoin(VendingMachine machine, Integer coin) {
        System.out.println("Inserted coin: "+coin);
        machine.addCoin(coin);
        return machine.getHasCoinState();
    }

    @Override
    public State selectItem(VendingMachine machine) {
        System.out.println("Please insert coin first");
        return machine.getNoCoinState();
    }

    @Override
    public State dispense(VendingMachine machine) {
        System.out.println("Please insert coin first");
        return machine.getNoCoinState();
    }

    @Override
    public State refill(VendingMachine machine, Integer quantity) {
        machine.incItem(quantity);
        System.out.println("New quantity added: "+quantity);
        System.out.println("Total quantity: "+machine.getTotalQuantity());
        return machine.getNoCoinState();
    }

    @Override
    public String getStateName() {
        return "NO_COIN_STATE";
    }
}

class HasCoinState implements State{

    @Override
    public State insertCoin(VendingMachine machine, Integer coin) {
        System.out.println("Adding additional coin: "+coin);
        machine.addCoin(coin);
        return machine.getHasCoinState();
    }

    @Override
    public State selectItem(VendingMachine machine) {
        if(machine.getPricePerItem() <= machine.getInsertedCoins()){

            int leftCoins = machine.getInsertedCoins() - machine.getPricePerItem();
            if(leftCoins > 0){
                System.out.println("Returning left coins: "+leftCoins);
            }
            machine.setInsertedCoins(0);
            return machine.getDispenseState();
        }
        else{
            int neededCoin = machine.getPricePerItem() - machine.getInsertedCoins();
            System.out.println("Please insert additional coin: "+neededCoin);
            return machine.getHasCoinState();
        }
    }

    @Override
    public State dispense(VendingMachine machine) {
        System.out.println("Please select item first");
        return machine.getHasCoinState();
    }

    @Override
    public State refill(VendingMachine machine, Integer quantity) {
        System.out.println("Cannot refill while there is a coin inserted. Please remove the coin first.");
        return machine.getHasCoinState();
    }

    @Override
    public String getStateName() {
        return "HAS_COIN_STATE";
    }
}

class DispenseState implements State{

    @Override
    public State insertCoin(VendingMachine machine, Integer coin) {
        System.out.println("Can't insert coin while dispensing. Please wait.");
        return machine.getDispenseState();
    }

    @Override
    public State selectItem(VendingMachine machine) {
        System.out.println("Already selected item. Please wait while dispensing.");
        return machine.getDispenseState();
    }

    @Override
    public State dispense(VendingMachine machine) {
        System.out.println("Dispensing item...");
        machine.decItem();
        if(machine.getTotalQuantity() > 0){
            return machine.getNoCoinState();
        }
        else{
            System.out.println("Item is sold out.");
            return machine.getSoldOutState();
        }
    }

    @Override
    public State refill(VendingMachine machine, Integer quantity) {
        System.out.println("Cannot refill while dispensing. Please wait.");
        return machine.getDispenseState();
    }

    @Override
    public String getStateName() {
        return "DISPENSE_STATE";
    }
}

class SoldOutState implements State{

    @Override
    public State insertCoin(VendingMachine machine, Integer coin) {
        System.out.println("Item is sold out. Cannot insert coin. First need to refill.");
        return machine.getSoldOutState();
    }

    @Override
    public State selectItem(VendingMachine machine) {
        System.out.println("Item is sold out. Cannot Select Item. First need to refill.");
        return machine.getSoldOutState();
    }

    @Override
    public State dispense(VendingMachine machine) {
        System.out.println("Item is sold out. Cannot dispense item. First need to refill.");
        return machine.getSoldOutState();
    }

    @Override
    public State refill(VendingMachine machine, Integer quantity) {
        System.out.println("Refilling machine with quantity: "+quantity);
        machine.incItem(quantity);
        return machine.getNoCoinState();
    }

    @Override
    public String getStateName() {
        return "SOLD_OUT_STATE";
    }
}


public class Main {
    public static void main(String[] args) {

        // create new vending machine
        VendingMachine machine = new VendingMachine(1,20);

        // First try to select item without inserting coin
        System.out.println("Try to select item without inserting coin:");
        machine.selectItem();
        System.out.println("\n");

        System.out.println("Insert coin");
        machine.insertCoin(10);
        System.out.println("\n");

        System.out.println("Try to select item with insufficient coin:");
        machine.selectItem();
        System.out.println("\n");

        System.out.println("Insert additional coin:");
        machine.insertCoin(10);
        System.out.println("\n");

        System.out.println("Select item with sufficient coin:");
        machine.selectItem();
        System.out.println("\n");

        System.out.println("Trying to add coin while dispensing");
        machine.insertCoin(50);
        System.out.println("\n");

        System.out.println("Trying to refill in dispense state");
        machine.refill(5);
        System.out.println("\n");

        System.out.println("Dispensing item");
        machine.dispense();
        System.out.println("\n");

        System.out.println("Trying to insert coin in sold out state");
        machine.insertCoin(10);
        System.out.println("\n");

        System.out.println("Refilling machine with items");
        machine.refill(5);
        System.out.println("\n");


    }
}