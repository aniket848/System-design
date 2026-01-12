package factory;

import model.Restaurant;
import model.User;
import model.MenuItem;
import model.Order;
import strategy.Payment;

import java.util.List;

public interface orderFactory {

    public Order createOrder(User user, List<MenuItem> orderItems, Restaurant restaurant, double totalPrice,
                             Payment payment, String orderType);
}
