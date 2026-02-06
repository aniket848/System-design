package Coupon;

import Cart.*;

    public abstract class coupon {

    private coupon nextCoupon;

    public void setNextCoupon(coupon nextCoupon){
        this.nextCoupon = nextCoupon;
    }

    public coupon getNextCoupon(){
        return nextCoupon;
    }

    public boolean isCombinable(){
        return true;
    }

    public boolean isNextCoupon(){
        return nextCoupon!=null;
    }

    public void applyDiscount(Cart cart){
        if(isApplicable(cart)){
            double discountValue = getDiscount(cart);
            cart.applyDiscount(discountValue);
        }
        if(!isCombinable()){
            return;
        }
        if(nextCoupon!=null){
            nextCoupon.applyDiscount(cart);
        }
    }

    public abstract boolean isApplicable(Cart cart);
    public abstract double getDiscount(Cart cart);
    public abstract String getName();
}





