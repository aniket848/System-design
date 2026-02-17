package Managers;

import Strategies.Inventory;

public class InventoryManager {

    private Inventory inventory;

    public InventoryManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addProduct(Integer sku, Integer quantity){
        inventory.addProduct(sku, quantity);
    }

    public void removeProduct(Integer sku, Integer quantity){
        inventory.removeProduct(sku, quantity);
    }

    public Boolean checkStock(Integer sku, Integer quantity){
        return inventory.checkStock(sku, quantity);
    }

    public void showAllProducts(){
        inventory.showAllProducts();
    }

    public Integer getCurrentInventory(Integer sku){
        return inventory.getCurrentInventory(sku);
    }
}
