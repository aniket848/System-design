package model;

public class PickupOrder extends Order {

    private String restaurantAddress;

    @Override
    public String getType() {
        return "Pickup";
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }
}
