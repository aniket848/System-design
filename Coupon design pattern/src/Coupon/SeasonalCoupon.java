package Coupon;

import Cart.Cart;
import discountDesignPattern.discountDesignPattern;
import factory.discountFactory;
import Enum.DiscountEnum;
import model.cartItem;

public class SeasonalCoupon extends coupon{

    private discountDesignPattern ds;
    private String seasonName;
    private Integer percentDiscountValue;

    public SeasonalCoupon(String seasonName, Integer percentDiscountValue) {
        this.percentDiscountValue = percentDiscountValue;
        this.seasonName = seasonName;
        this.ds = discountFactory.getInstance().createDiscount(DiscountEnum.PERCENT,percentDiscountValue,0);
    }


    @Override
    public boolean isApplicable(Cart cart) {
        // only those items are applicable which are winter related season b/c of sale
        boolean flag = false;
        for(cartItem item: cart.getItems()){
            if(item.getProduct().getCategory().equalsIgnoreCase(this.seasonName)){
                flag = true;
                break;
            }
        }

        return flag;
    }

    @Override
    public double getDiscount(Cart cart) {
        double basePrice = 0.0;
        for(cartItem item: cart.getItems()){
            if(item.getProduct().getCategory().equalsIgnoreCase(this.seasonName)){
                basePrice += item.getPrice();
            }
        }
        return this.ds.applyDiscount(basePrice);
    }

    public Integer getPercentDiscountValue(){
        return percentDiscountValue;
    }

    @Override
    public String getName() {
        return "Seasonal Coupon for " + seasonName + " with percent discount value of " + percentDiscountValue;
    }
}
