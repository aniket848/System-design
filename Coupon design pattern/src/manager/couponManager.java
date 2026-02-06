package manager;

import Cart.Cart;
import Coupon.coupon;
import model.cartItem;

import java.util.ArrayList;
import java.util.List;

//SINGLETON
public class couponManager {

    private static couponManager instance = null;
    private coupon head = null;

    private couponManager(){

    }

    public static couponManager getInstance(){
        if(instance == null){
            instance = new couponManager();
        }
        return instance;
    }

    public void addCoupon(coupon coupon){

        if(head == null){
            head = coupon;
            head.setNextCoupon(null);
        }
        else{
            coupon current = head;
            while(current!=null && current.isNextCoupon()){
                 current = current.getNextCoupon();
            }
            if(current!=null)
               current.setNextCoupon(coupon);
            else
               current.setNextCoupon(null);
        }
    }

    public List<String> getApplicableCoupons(Cart cart){

        coupon current = head;
        List<String> res = new ArrayList<>();

        while(current!=null){
            if(current.isApplicable(cart)){
                res.add(current.getName());
            }
            current = current.getNextCoupon();
        }

        return res;

    }

    public void applyAllCoupon(Cart cart){

//        coupon current = head;
//
//        while(current!=null){
//            current.applyDiscount(cart);
//            System.out.println("Applied coupon: " + current.getName() );
//            current = current.getNextCoupon();
//        }
        head.applyDiscount(cart);
    }

    public double getFinalDiscountePrice(Cart cart){
        return cart.getFinalDiscountedAmount();
    }


}
