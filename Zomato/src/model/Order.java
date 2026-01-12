package model;

import strategy.Payment;

import java.util.List;

public abstract class Order {

    private static Integer nextOrderId = 0;
    private Integer orderId;
    private User user;
    private Restaurant restaurant;
    private List<MenuItem> orderItems;
    private double totalPrice;
    private Payment paymentStrategy;
    private String scheduleTime;

    public abstract String getType();

    public String getScheduleTime() {
        return scheduleTime;
    }

    public User getUser() {
        return user;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    Order(){
        this.orderId  = ++nextOrderId;
        this.user = null;
        this.restaurant = null;
        this.totalPrice = 0;
    }

    public Boolean checkout(){
        System.out.println("PAYMENT PROCESSED for order Id " + this.orderId + "  --------------------------- ");
        paymentStrategy.pay(totalPrice);
        return true;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setPaymentStrategy(Payment paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<MenuItem> orderItems) {
        this.orderItems = orderItems;
        for(MenuItem item:orderItems){
            totalPrice+= item.getPrice();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
