package Model;

import Managers.InventoryManager;
import Strategies.ReplenishStrategy;

import java.util.HashMap;

public class DarkStore {

    private InventoryManager inventoryManager;
    private Double x,y;
    private ReplenishStrategy replenishStrategy;
    private String name;

    public DarkStore(String name, Double x, Double y, InventoryManager inventoryManager, ReplenishStrategy replenishStrategy) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.inventoryManager = inventoryManager;
        this.replenishStrategy = replenishStrategy;
    }

    public Double getDistance(Double ux, Double uy){
        return Math.sqrt(Math.pow(ux-x,2)+Math.pow(uy-y,2));
    }

    public void runReplenishment(HashMap<Integer,Integer> items){
        replenishStrategy.replenish(items);
    }

    public void getAllProducts(){
        inventoryManager.showAllProducts();
    }

    public Boolean checkProductAvailability(Integer sku, Integer quantity){
        return inventoryManager.checkStock(sku,quantity);
    }

     public void reduceInventory(Integer sku, Integer quantity){
        inventoryManager.removeProduct(sku,quantity);
     }

     public String getName() {
         return name;
     }

    public Integer currentInventory(Integer sku){
        return inventoryManager.getCurrentInventory(sku);
    }
}
