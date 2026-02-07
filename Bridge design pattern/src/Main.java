interface engine{
    public void start();
}

class DieselEngine implements engine{
    @Override
    public void start() {
        System.out.println("Diesel Engine Started");
    }
}

class PetrolEngine implements engine{
    @Override
    public void start() {
        System.out.println("Petrol Engine Started");
    }
}

class ElectricEngine implements engine{
    @Override
    public void start() {
        System.out.println("Electric Engine Started");
    }
}

abstract class Car{
    protected engine e;
    Car(engine e){
        this.e = e;
    }

    public abstract void drive();
}

class sportsCar extends Car{

    sportsCar(engine e){
        super(e);
    }

    @Override
    public void drive() {
        e.start();
        System.out.println("Driving sports car");
    }
}

class suvCar extends Car{

    suvCar(engine e){
        super(e);
    }

    @Override
    public void drive() {
        e.start();
        System.out.println("Driving SUV car");
    }
}



public class Main {
    public static void main(String[] args) {

        engine petrolEngine = new PetrolEngine();
        engine dieselEngine = new DieselEngine();
        engine electricEngine = new ElectricEngine();

        Car Fortuner = new sportsCar(petrolEngine);
        Car BMW = new suvCar(dieselEngine);

        Fortuner.drive();
        BMW.drive();

    }
}