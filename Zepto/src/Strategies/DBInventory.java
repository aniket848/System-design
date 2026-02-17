package Strategies;

import Factory.ProductFactory;
import Model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBInventory implements Inventory{

    private HashMap<Integer, Integer> quantityStock;
    private HashMap<Integer, Product> productStock;

    public DBInventory(){
        this.quantityStock = new HashMap<>();
        this.productStock = new HashMap<>();
    }

    @Override
    public void addProduct(Integer sku, Integer quantity) {
        quantityStock.put(sku,quantity);
        Product p = ProductFactory.getInstance().getProduct(sku);
        productStock.put(sku, p);
    }

    @Override
    public void removeProduct(Integer sku, Integer quantity) {
         if(quantityStock.get(sku) >= quantity){
             quantityStock.put(sku, quantityStock.get(sku)-quantity);
         } else {
             System.out.println("Not enough stock to remove");
         }
    }

    @Override
    public Boolean checkStock(Integer sku, Integer quantity) {
        return quantityStock.get(sku) >= quantity;
    }

    @Override
    public void showAllProducts() {

        for(Map.Entry<Integer,Product> entry: productStock.entrySet()){
            Integer sku = entry.getKey();
            Product p = entry.getValue();
            Integer quantity = quantityStock.get(sku);
            System.out.println(p.toString() + " Quantity: " + quantity);
        }
    }

    @Override
    public Integer getCurrentInventory(Integer sku) {
        return quantityStock.get(sku);
    }
}
