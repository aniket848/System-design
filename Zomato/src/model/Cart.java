package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart {

    private Restaurant restaurant;
    private List<MenuItem> menuItemsList = new ArrayList<>();

    public void addToCart(Integer itemId){
        MenuItem addToCarItem = null;

        for(MenuItem items: restaurant.getMenuList()){
            if(items.getItemId().equals(itemId)){
                addToCarItem = items;
            }
        }

        if(addToCarItem !=null)
          menuItemsList.add(addToCarItem);
    }

    public double calculateTotalPrice(){
        double price = 0;
        for(MenuItem item: menuItemsList){
            price += item.getPrice();
        }
        return price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItem> getMenuItemsList() {
        return menuItemsList;
    }

    public void setMenuItemsList(List<MenuItem> menuItemsList) {
        this.menuItemsList = menuItemsList;
    }
}
