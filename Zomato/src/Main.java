
import model.Restaurant;
import model.User;
import strategy.CreditCardPayment;
import strategy.Payment;
import strategy.UPIPayment;

public class Main {
    public static void main(String[] args) {

        //Initialize Zomato restaurant
        zomato zomato = new zomato();

        // search restaurant via location
        Restaurant searchRestaurant1 = zomato.searchRestaurantByLocation("Bareilly");
        Restaurant searchRestaurant2 = zomato.searchRestaurantByLocation("Ghaziabad");

        // create user or assume it as a logged-in user
        User user = new User(814,"Aman Pareek");
        User user2 = new User(533,"Sanjeet Kumar");

        // Add items from selected location in cart for the logged-in User
        zomato.addToCart(user, searchRestaurant1,1);
        zomato.addToCart(user,searchRestaurant1, 3);

        zomato.addToCart(user2,searchRestaurant2,2);
        zomato.addToCart(user2,searchRestaurant2,1);


        // Before ordering the item, choose the payment type
        Payment UPIPayment = new UPIPayment("905379634");
        Payment CreditCardPayment = new CreditCardPayment("3460870176109745");


        // Create Order -> Either Delivery order or pickup order
        zomato.createCurrentOrder(user,UPIPayment,"Delivery");
        zomato.createScheduledOrder(user2,CreditCardPayment,"Pickup");


        // List down all the orders and checkout
        zomato.checkout();

    }
}