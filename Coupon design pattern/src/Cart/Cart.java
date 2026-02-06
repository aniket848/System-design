package Cart;

import model.Product;
import model.cartItem;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<cartItem> items;
    private Product product;
    private boolean isPremiumCustomer;
    private double totalAmount;
    private double finalDiscountedAmount;

    public Cart(){
        items = new ArrayList<>();
        product = null;
        totalAmount = 0.0;
        finalDiscountedAmount = 0.0;
    }

    public void addCartItem(Product product, int quantity){
        //this.product = product;
        cartItem cartItem = new cartItem(product, quantity);
        items.add(cartItem);
    }

    public List<cartItem> getItems(){
        return items;
    }

//    public Product getProduct(){
//        return product;
//    }

    public boolean isPremiumCustomer(){
        return true;
    }

    public double calculateTotalAmount(){
        double total = 0.0;
        for(cartItem item:items){
            total += item.getPrice();
        }
        this.totalAmount = total;
        if(this.finalDiscountedAmount == 0.0)
           this.finalDiscountedAmount = total;
        return total;
    }

    public void applyDiscount(double discountValue){
        finalDiscountedAmount -= discountValue;
    }

    public double getFinalDiscountedAmount(){
        return finalDiscountedAmount;
    }

}
