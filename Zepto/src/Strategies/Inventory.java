package Strategies;

public interface Inventory {

    public void addProduct(Integer sku, Integer quantity);
    public void removeProduct(Integer sku, Integer quantity);
    public Boolean checkStock(Integer sku, Integer quantity);
    public void showAllProducts();
    public Integer getCurrentInventory(Integer sku);
}
