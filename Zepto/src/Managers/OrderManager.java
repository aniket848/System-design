package Managers;

import Model.*;

import java.util.*;

public class OrderManager {

    private static OrderManager instance = null;
    private List<Order> orderList;
    private DarkStoreManager darkStoreManager;

    private OrderManager(DarkStoreManager darkStoreManager) {
        this.darkStoreManager = darkStoreManager;
        this.orderList = new ArrayList<>();
    }

    public static OrderManager getInstance(DarkStoreManager darkStoreManager){
        if(instance == null){
            instance = new OrderManager(darkStoreManager);
        }
        return instance;
    }

    public void addOrder(Order order){
        this.orderList.add(order);
    }

    public void placeOrder(User user){
        for(Order order : orderList){
            this.processOrder(user,order);
        }
        this.summary(orderList);
    }

    public void processOrder(User user, Order order){
        // GET ALL NEARBY DARK STORES ACCORDING TO THE USER LOCATION
        List<DarkStore> nearbyDarkStores = darkStoreManager.getNearbyDarkStore(user.getX(),user.getY(),10.0); // under 5km
        HashSet<DarkStore> visitedDarkStores = new HashSet<>();


        // ITERATE THROUGH THE ORDER LIST AND CHECK HOW MANY DARK SORES WE NEED TO VISIT TO COMPLETE THE ORDER
        System.out.println("For Order Id-: "+ order.getOrderId());
        HashMap<Product,Integer> orderItems = order.getProductList();

        for(Map.Entry<Product,Integer> entry : orderItems.entrySet()){
            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            for(DarkStore darkStore : nearbyDarkStores){
                if(darkStore.checkProductAvailability(product.getSku(),quantity)){
                    System.out.println("Product "+ product.getName() + " is available in Dark Store "+ darkStore.getName()+ " with quantity "+ quantity);
                    darkStore.reduceInventory(product.getSku(), quantity);
                    visitedDarkStores.add(darkStore);
                    break;
                }
                else{
                    Integer currentQuantity = darkStore.currentInventory(product.getSku());
                    quantity -= currentQuantity;
                    System.out.println("Product "+ product.getName() + " is partially available in Dark Store "+ darkStore.getName() + " with quantity "+ currentQuantity);
                    darkStore.reduceInventory(product.getSku(), currentQuantity);
                    visitedDarkStores.add(darkStore);
                }
            }// darkStore
        }

        // AFTER FINDING DARK STORES, ASSIGN DELIVERY AGENTS WHICH ARE NEARBY TO DARK STORES AND BASED ON RATING
        for(DarkStore darkStore : visitedDarkStores){
            DeliveryPartner deliveryPartner = darkStoreManager.getDeliveryPartner(darkStore);
            System.out.println("Name delivery agent assigned for Dark Store "+ darkStore.getName() + " -: "+ deliveryPartner.getName());
            order.addDeliveryPartner(deliveryPartner);
        }

    }

    public void summary(List<Order> orders){
        for(Order order : orders){
            System.out.println("Order Id-: "+ order.getOrderId());
            System.out.println("Products-:");
            for(Map.Entry<Product,Integer> entry : order.getProductList().entrySet()){
                System.out.println(entry.getKey().getName() + " with quantity "+ entry.getValue());
            }
            System.out.println("Total cost-: "+ order.getTotalPrice());
            System.out.println("Delivery Partners-:");
            for(DeliveryPartner deliveryPartner : order.getDeliveryPartnerList()){
                System.out.println(deliveryPartner.getName());
            }
        }
    }

}
