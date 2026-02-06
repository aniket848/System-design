// discount design pattern


import Cart.Cart;
import Coupon.SeasonalCoupon;
import Coupon.bankCoupon;
import Coupon.coupon;
import manager.couponManager;
import model.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        couponManager couponManager = manager.couponManager.getInstance();


        // create Product
        Product product1 = new Product("Laptop", "WINTER", 1000);
        Product product2 = new Product("Phone", "SUMMER", 500);
        Product product3 = new Product("Headphones", "WINTER", 200);
        Product product4 = new Product("Jacket", "WINTER", 1300);

        // Create cart and add item to it
        Cart cart  = new Cart();
        cart.addCartItem(product1,2);
        cart.addCartItem(product2,1);
        cart.addCartItem(product3,4);

        // CREATE coupons
        coupon bankCoupon = new bankCoupon("AXIS", 100);
        coupon seasonalCoupon = new SeasonalCoupon("WINTER", 20);
        coupon bulkShoppingCoupon = new Coupon.bulkShoppingCoupon(2000,10);

        // ADD coupon for cart
        couponManager.addCoupon(bankCoupon);
        couponManager.addCoupon(seasonalCoupon);
        couponManager.addCoupon(bulkShoppingCoupon);

        // TOTAL PRICE OF THE CART WITHOUT DISCOUNT
        System.out.println("Total price of the cart without discount: " + cart.calculateTotalAmount());

        //SHOW ALL APPLICABLE COUPONS
        System.out.println("Applicable coupons for the cart: ");
        List<String> res = couponManager.getApplicableCoupons(cart);
        for(String couponName: res){
            System.out.println(couponName);
        }

        System.out.println("\n");

        // apply all coupons
        couponManager.applyAllCoupon(cart);

        System.out.println("\n");

        // FINAL DISCOUNTED PRICE
        System.out.println("Total price of the cart after applying all coupons: " + couponManager.getFinalDiscountePrice(cart));




    }
}