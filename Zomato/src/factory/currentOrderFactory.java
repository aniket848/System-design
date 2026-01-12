package factory;

import model.*;
import strategy.Payment;

import java.util.List;

public class currentOrderFactory implements orderFactory{

    @Override
    public Order createOrder(User user, List<MenuItem> orderItems, Restaurant restaurant, double totalPrice, Payment payment,
                             String orderType) {
        Order order;

        if(orderType.equals("Delivery")){
            order = new DeliveryOrder();
        }
        else{
            order = new PickupOrder();
        }

        order.setRestaurant(restaurant);
        order.setOrderItems(orderItems);
        order.setUser(user);
        order.setTotalPrice(totalPrice);
        order.setPaymentStrategy(payment);
        order.setScheduleTime("Current Date and Time");

        return order;
    }
}
