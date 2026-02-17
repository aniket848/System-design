import Model.User;

public class Main {
    public static void main(String[] args) {

        // Zepto class object
        zepto zepto = new zepto();

        // Create User
        User user = new User("Aniket",2.0,4.0);

        // Set user or you can say logged in with this user
        zepto.setUser(user);

        // Add items in cart
        zepto.addItemsInCart(1001, 12);
        zepto.addItemsInCart(1002, 10);
        zepto.addItemsInCart(1005,5);
        zepto.addItemsInCart(1006,24);

        // Create Order
        zepto.checkOut();

        // Place Order
        zepto.placeOrder();

    }
}