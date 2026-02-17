import Factory.ProductFactory;
import Managers.DarkStoreManager;
import Managers.InventoryManager;
import Managers.OrderManager;
import Model.*;
import Strategies.DBInventory;
import Strategies.ThresholdReplenishStrategy;

import java.util.HashMap;

public class zepto {

    private User user=null;
    private ProductFactory productFactory;
    private DarkStoreManager darkStoreManager;
    private OrderManager orderManager;

    public zepto(){
        // create product
        productFactory = ProductFactory.getInstance();
        darkStoreManager = DarkStoreManager.getInstance();
        orderManager = OrderManager.getInstance(darkStoreManager);

        productFactory.createProduct(1001);
        productFactory.createProduct(1002);
        productFactory.createProduct(1003);
        productFactory.createProduct(1004);
        productFactory.createProduct(1005);
        productFactory.createProduct(1006);

        this.addDarkStores();
    }

    public void addDarkStores(){
        InventoryManager inventoryManager1 = new InventoryManager(new DBInventory());
        DarkStore darkStore1 = new DarkStore("Rajendra nagar", 10.0, 20.0, inventoryManager1,
                new ThresholdReplenishStrategy(3,inventoryManager1));

        InventoryManager inventoryManager2 = new InventoryManager(new DBInventory());
        DarkStore darkStore2 = new DarkStore("Lajpat nagar", 2.0, 3.0, inventoryManager2,
                new ThresholdReplenishStrategy(3,inventoryManager2));

        InventoryManager inventoryManager3 = new InventoryManager(new DBInventory());
        DarkStore darkStore3 = new DarkStore("IVRI", 5.0, 20.0, inventoryManager3,
                new ThresholdReplenishStrategy(3,inventoryManager3));

        InventoryManager inventoryManager4 = new InventoryManager(new DBInventory());
        DarkStore darkStore4 = new DarkStore("Karmchari Nagar", 7.0, 2.0, inventoryManager4,
                new ThresholdReplenishStrategy(3,inventoryManager4));

        darkStoreManager.addDarkStore(darkStore1);
        darkStoreManager.addDarkStore(darkStore2);
        darkStoreManager.addDarkStore(darkStore3);
        darkStoreManager.addDarkStore(darkStore4);

        // Fill Inventory

        // INVENTORY1
        inventoryManager1.addProduct(1001,5);
        inventoryManager1.addProduct(1002,10);
        inventoryManager1.addProduct(1003,3);
        inventoryManager1.addProduct(1004,9);
        inventoryManager1.addProduct(1005,50);
        inventoryManager1.addProduct(1006,11);

        // INVENTORY2
        inventoryManager2.addProduct(1001,15);
        inventoryManager2.addProduct(1002,5);
        inventoryManager2.addProduct(1003,7);
        inventoryManager2.addProduct(1004,3);
        inventoryManager2.addProduct(1005,6);
        inventoryManager2.addProduct(1006,11);


        // INVENTORY3
        inventoryManager3.addProduct(1001,9);
        inventoryManager3.addProduct(1002,1);
        inventoryManager3.addProduct(1003,7);
        inventoryManager3.addProduct(1004,4);
        inventoryManager3.addProduct(1005,2);
        inventoryManager3.addProduct(1006,8);


        // INVENTORY4
        inventoryManager4.addProduct(1001,9);
        inventoryManager4.addProduct(1002,13);
        inventoryManager4.addProduct(1003,17);
        inventoryManager4.addProduct(1004,43);
        inventoryManager4.addProduct(1005,12);
        inventoryManager4.addProduct(1006,80);
    }

    public void setUser(User user){
        this.user = user;
    }

    public void addItemsInCart(Integer sku, Integer quantity){
        if(user==null){
            System.out.println("Please set user before adding items to cart.");
            return;
        }
        Cart cart = user.getCart();
        Product p = productFactory.getProduct(sku);
        cart.addItem(p, quantity);
    }

    public Double getTotalCartValue(){
        if(user==null){
            System.out.println("Please set user before adding items to cart.");
            return 0.0;
        }
        Cart cart = user.getCart();
        return cart.getTotalPrice();
    }

    public HashMap<Product,Integer> getCartItems(){
        if(user==null){
            System.out.println("Please set user before adding items to cart.");
            return null;
        }
        Cart cart = user.getCart();
        return cart.getItemList();
    }

    public void showCartItems(){
        if(user==null){
            System.out.println("Please set user before adding items to cart.");
            return;
        }
        Cart cart = user.getCart();
        cart.showAllCartItems();
    }

    public void checkOut(){
        if(user==null){
            System.out.println("Please set user before adding items to cart.");
            return;
        }
        Cart cart = user.getCart();
        Order order = new Order();
        order.setUser(user);
        for(HashMap.Entry<Product,Integer> entry : cart.getItemList().entrySet()){
            order.addProduct(entry.getKey(), entry.getValue());
        }
        orderManager.addOrder(order);
    }

    public void placeOrder(){
        orderManager.placeOrder(user);
    }


}
