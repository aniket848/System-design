package Strategies;

import Managers.InventoryManager;

import java.util.HashMap;
import java.util.Map;

public class ThresholdReplenishStrategy implements ReplenishStrategy {

    private Integer threshold;
    private InventoryManager inventoryManager;

    public ThresholdReplenishStrategy(Integer threshold, InventoryManager inventoryManager) {
        this.threshold = threshold;
        this.inventoryManager = inventoryManager;
    }


    @Override
    public void replenish(HashMap<Integer, Integer> items) {

        for(Map.Entry<Integer,Integer> entry: items.entrySet()){
            Integer sku = entry.getKey();
            Integer thresholdQuantity = entry.getValue();
            if(!inventoryManager.checkStock(sku, thresholdQuantity)){ // if quantity is below, replenish
                System.out.println("Replenishing product with SKU: " + sku);
                inventoryManager.addProduct(sku, thresholdQuantity);
            }
        }
    }
}
