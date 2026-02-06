package discountDesignPattern;

public class flatDiscountStrategy implements discountDesignPattern {
    private double flatDiscount;

    public flatDiscountStrategy(){

    }

    public flatDiscountStrategy(double flatDiscount) {
        this.flatDiscount = flatDiscount;
    }

    @Override
    public double applyDiscount(double basePrice) {
        double totalDiscount = flatDiscount;
        System.out.println("flat discount amount: " + totalDiscount);
        return totalDiscount;
    }
}
