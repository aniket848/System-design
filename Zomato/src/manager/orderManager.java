package manager;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class orderManager {

    private static orderManager instance = null;
    private List<Order> orderList = new ArrayList<>();

    private orderManager(){
    }

    public static orderManager getInstance(){
        if(instance == null){
            instance = new orderManager();
        }
        return instance;
    }

    public List<Order> getOrderList() {
        return orderList;
    }


    public void addOrder(Order order){
        orderList.add(order);
    }

    public void deleteOrder(Order order){
        orderList.remove((order));
    }

    public void listOfOrder(){
        System.out.println("List of all the orders.....  ");
        for(Order order: orderList){
            System.out.println("Order id: "+ order.getOrderId() + " of type :" + order.getType()
                    + " with total price :" + order.getTotalPrice() + " at scheduled time : "+ order.getScheduleTime()
            );
        }
    }
}
