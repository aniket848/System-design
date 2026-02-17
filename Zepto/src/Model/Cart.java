package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private HashMap<Product, Integer> itemList;
    private Double totalPrice;

    public Cart(){
        itemList = new HashMap<>();
        totalPrice = 0.0;
    }


    public Double getTotalPrice(){
        for(Map.Entry<Product,Integer> mm: itemList.entrySet()){
            totalPrice += mm.getKey().getPrice() * mm.getValue();
        }
        return totalPrice;
    }

    public void showAllCartItems(){
        for(Map.Entry<Product,Integer> mm: itemList.entrySet()){
            System.out.println(mm.getKey().toString() + " Quantity: " + mm.getValue());
        }
    }

    public HashMap<Product, Integer> getItemList(){
        return itemList;
    }

    public void addItem(Product p, Integer quantity){
        itemList.put(p,quantity);
    }
}
