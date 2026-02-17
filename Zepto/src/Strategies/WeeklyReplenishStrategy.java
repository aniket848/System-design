package Strategies;

import Managers.InventoryManager;

import java.util.HashMap;
import java.util.Map;

public class WeeklyReplenishStrategy implements ReplenishStrategy{

    private InventoryManager inventoryManager;

    public WeeklyReplenishStrategy(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    @Override
    public void replenish(HashMap<Integer, Integer> items) {
        System.out.println("Replenishing inventory on a weekly basis...");
        for(Map.Entry<Integer,Integer> entry:items.entrySet()){
            inventoryManager.addProduct(entry.getKey(), entry.getValue());
        }
    }
}
