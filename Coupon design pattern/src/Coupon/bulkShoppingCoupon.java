package Coupon;

import Cart.Cart;
import discountDesignPattern.discountDesignPattern;
import factory.discountFactory;
import Enum.DiscountEnum;

public class bulkShoppingCoupon extends coupon{

    private Integer minThreshold;
    private discountDesignPattern ds;
    private Integer percentDiscountValue;


    public bulkShoppingCoupon(Integer minThreshold, Integer percentDiscountValue) {
        this.percentDiscountValue = percentDiscountValue;
        this.minThreshold = minThreshold;
        this.ds = discountFactory.getInstance().createDiscount(DiscountEnum.PERCENT_WITH_CAP,
                percentDiscountValue,minThreshold);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        double totalPrice = cart.calculateTotalAmount();
        if(totalPrice >= minThreshold)
            return true;
        return false;
    }

    @Override
    public double getDiscount(Cart cart) {
        return ds.applyDiscount(cart.calculateTotalAmount());
    }

    public Integer getMinThreshold(){
        return minThreshold;
    }

    public Integer getPercentDiscountValue(){
        return percentDiscountValue;
    }

    @Override
    public String getName() {
        return "Bulk Shopping Coupon with minimum threshold of " + minThreshold + " and % discount value of " + percentDiscountValue;
    }
}