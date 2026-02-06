package Coupon;

import Cart.Cart;
import discountDesignPattern.discountDesignPattern;
import factory.discountFactory;
import Enum.DiscountEnum;

import java.util.Objects;

public class bankCoupon extends coupon {

    private discountDesignPattern ds;
    private String bankName;
    private Integer flatDiscountalue;

    public bankCoupon(String bankName, Integer flatDiscountalue) {
        this.bankName = bankName;
        this.flatDiscountalue = flatDiscountalue;
        this.ds = discountFactory.getInstance().createDiscount(DiscountEnum.FLAT,flatDiscountalue,0);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        // bank coupon only apply for axis and icici bank;
        return Objects.equals(bankName, "ICICI") || Objects.equals(bankName, "AXIS");
    }

    @Override
    public double getDiscount(Cart cart) {
        // logic to calculate the discount for the bank coupon
        double basePrice = cart.calculateTotalAmount();
        return ds.applyDiscount(basePrice);
    }

    public Integer getFlatDiscountalue(){
        return flatDiscountalue;
    }

    @Override
    public String getName() {
        return "Bank Coupon for " + bankName + "with flat discount value of " + flatDiscountalue;
    }
}
