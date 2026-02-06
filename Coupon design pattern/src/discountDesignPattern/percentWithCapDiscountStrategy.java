package discountDesignPattern;

public class percentWithCapDiscountStrategy implements discountDesignPattern {

    private Integer cap;
    private Integer percent;

    public percentWithCapDiscountStrategy() {

    }

    public percentWithCapDiscountStrategy(Integer percent, Integer cap) {
        this.percent = percent;
        this.cap = cap;
    }

    @Override
    public double applyDiscount(double basePrice) {
        double totalDiscount = (basePrice * percent / 100);
        System.out.println("Percent cap discount amount: " + Integer.min((int)totalDiscount,this.cap));
        if (totalDiscount < cap) {
            return totalDiscount;
        } else {
            return (double) cap;
        }
    }
}
