import factory.currentOrderFactory;
import factory.orderFactory;
import factory.scheduledOrderFactory;
import manager.orderManager;
import manager.restaurantManager;
import model.*;
import strategy.EmailNotification;
import strategy.Payment;
import strategy.SMSNotification;
import strategy.notification;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class zomato {

    public zomato(){
        initializeRestaurant();
    }

    public void initializeRestaurant(){
        Restaurant res1 = new Restaurant("Punjabiyan da dhaba", "Bareilly");
        Restaurant res2 = new Restaurant("Tandoori Gali", "Ghaziabad");

        res1.setMenuList(Arrays.asList(
                new MenuItem(1,"chicken momo",80.0),
                new MenuItem(2,"Shormaa",120.0),
                new MenuItem(3, "Tandoori momo", 120.0)
        ));

        res2.setMenuList(Arrays.asList(
                new MenuItem(1,"Tandoori chicken",160.0),
                new MenuItem(2,"Kadaayi chicken",150.0),
                new MenuItem(3, "Chicekn do pyaza", 160.0)
        ));

        restaurantManager resManager = restaurantManager.getInstance();
        resManager.addRestaurant(res1);
        resManager.addRestaurant(res2);

    }

    public Restaurant searchRestaurantByLocation(String location){

        return restaurantManager.getInstance().searchByLocation(location).getFirst();
    }

    public void addToCart(User user, Restaurant restaurant, Integer itemId){
        if(user.getCart() == null){
            user.setCart(new Cart());
        }
        Cart userCart = user.getCart();
        userCart.setRestaurant(restaurant);
        userCart.addToCart(itemId);
    }

    public Order createCurrentOrder(User user, Payment payment, String orderType){
        List<MenuItem> orderItems = user.getCart().getMenuItemsList();
        Restaurant restaurant = user.getCart().getRestaurant();
        double totalPrice = user.getCart().calculateTotalPrice();

        orderFactory orderObj = new currentOrderFactory();
        Order order =  orderObj.createOrder(user, orderItems, restaurant, totalPrice, payment, orderType);
        addOrder(order);
        return order;
    }

    public Order createScheduledOrder(User user, Payment payment, String orderType){
        List<MenuItem> orderItems = user.getCart().getMenuItemsList();
        Restaurant restaurant = user.getCart().getRestaurant();
        double totalPrice = user.getCart().calculateTotalPrice();

        orderFactory orderObj = new scheduledOrderFactory("Tomorrow");
        Order order =  orderObj.createOrder(user, orderItems, restaurant, totalPrice, payment, orderType);
        addOrder(order);
        return order;
    }

    public void addOrder(Order order){
        orderManager orderManager = manager.orderManager.getInstance();
        orderManager.addOrder(order);
    }

    public void checkout(){
        orderManager.getInstance().listOfOrder();
        for(Order order: orderManager.getInstance().getOrderList()){
            Boolean res = order.checkout();
            //System.out.println("order checkout done for "+res);

            if(res){
                if(order.getType().equals("Delivery")){
                    //System.out.println("delivery type");
                    notification notification = new SMSNotification("745012076");
                    notify(notification, order.getUser());
                }
                else{
                    notification notification = new EmailNotification("aniket123@gmail.com");
                    notify(notification, order.getUser());
                }
            }
        }
    }

    public void notify(notification notification, User user){
       // System.out.println("reached notify");
        notification.notifyUser(user);
    }

}
