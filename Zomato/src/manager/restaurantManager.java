package manager;

import model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class restaurantManager {

    private static restaurantManager instance = null;

    private restaurantManager(){
        restaurantList = new ArrayList<>();
    }

    public static restaurantManager getInstance(){
        if(instance == null){
            instance = new restaurantManager();
        }
        return instance;
    }

    private List<Restaurant> restaurantList;

    public void addRestaurant(Restaurant restaurant){
        restaurantList.add(restaurant);
    }

    public void removeRestaurant(Restaurant restaurant){
        restaurantList.remove(restaurant);
    }

    public List<Restaurant> searchByLocation(String location){
        List<Restaurant> result = new ArrayList<>();

        for(Restaurant restaurant: restaurantList){
            if(restaurant.getLocation().contains(location)){
                result.add(restaurant);
            }
        }//for

        return result;
    }

}
