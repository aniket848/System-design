import java.util.Objects;

interface Burger{
    public void prepare();
}

class simpleBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Simple burger with aloo tikki");
    }
}

class cheeseBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Burger with cheese inside it");
    }
}

class premiumBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Burger with cheese and vegetables with premium sauce");
    }
}

class simpleWheatBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Simple burger with wheat & aloo tikki");
    }
}

class cheeseWheatBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Burger with wheat & cheese inside it");
    }
}

class premiumWheatBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Burger with wheat & cheese and vegetables with premium sauce");
    }
}

interface Bread{
    public void prepare();
}


class garlicBread implements Bread{
    @Override
    public void prepare() {
        System.out.println("Garllic bread prepared");
    }
}

class premiumBread implements Bread{
    @Override
    public void prepare() {
        System.out.println("Premium bread prepared");
    }
}

class garlicWheatBread implements Bread{
    @Override
    public void prepare() {
        System.out.println("Garlic Wheat bread prepared");
    }
}

class premiumWheatBread implements Bread{
    @Override
    public void prepare() {
        System.out.println("Premium Wheat bread prepared");
    }
}



interface mealFactory{
    Burger createBurger(String type);
    Bread createBread(String type);
}

class singhFactory implements mealFactory{

    @Override
    public Burger createBurger(String type) {

        return switch (type) {
            case "simple"-> new simpleBurger();
            case "cheese"-> new cheeseBurger();
            case "premium"-> new premiumBurger();
            case null, default -> throw new Error("Select correct Burger type");
        };
    }

    @Override
    public Bread createBread(String type) {
        return switch(type){
            case "garlic" -> new garlicBread();
            case "premium" -> new premiumBread();
            case null, default -> throw new Error("Please select correct bread type");
        };
    }
}

class MehrotraFactory implements mealFactory{

    @Override
    public Burger createBurger(String type) {
        return switch (type){
            case "simple" -> new simpleWheatBurger();
            case "cheese" -> new cheeseWheatBurger();
            case "premium" -> new premiumWheatBurger();
            case null, default -> throw new Error("Please select correct type for burger creation");
        };
    }

    @Override
    public Bread createBread(String type) {
        return switch (type){
            case "garlic" -> new garlicWheatBread();
            case "premium" -> new premiumWheatBread();
            default -> throw new Error("Please select correct type for bread creation");
        };
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {

       mealFactory factory1 = new singhFactory();
       Burger burger = factory1.createBurger("simple");
       Bread bread = factory1.createBread("premium");

       mealFactory factory2 = new MehrotraFactory();
       Burger burger1 = factory2.createBurger("premium");
       Bread bread1 = factory2.createBread("garlic");

        burger.prepare();
        bread.prepare();

        burger1.prepare();
        bread1.prepare();
    }
}