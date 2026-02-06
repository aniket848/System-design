package discountDesignPattern;

public class percentDiscountStrategy implements discountDesignPattern {

    private Integer percent;

    public percentDiscountStrategy(){

    }

    public percentDiscountStrategy(Integer percent) {
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double basePrice) {
        double totalDiscount =  (basePrice * this.percent / 100);
        System.out.println("Percentage discount amount: " + totalDiscount);
        return totalDiscount;
    }
}
