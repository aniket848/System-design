package Managers;

import Model.DarkStore;
import Model.DeliveryPartner;

import java.util.ArrayList;
import java.util.List;

public class DarkStoreManager {

    private static DarkStoreManager instance = null;
    private List<DarkStore> dakrStoreList;

    private DarkStoreManager(){
       dakrStoreList = new ArrayList<>();
    }

    public static DarkStoreManager getInstance(){
        if(instance == null){
            instance = new DarkStoreManager();
        }
        return instance;
    }

    public void addDarkStore(DarkStore darkStore){
        dakrStoreList.add(darkStore);
    }

    public void removeDarkStore(DarkStore darkStore){
        dakrStoreList.remove(darkStore);
    }

    public List<DarkStore> getNearbyDarkStore(Double x,Double y, Double dist){
        List<DarkStore> result = new ArrayList<>();
        for(DarkStore darkStore : dakrStoreList){
            if(darkStore.getDistance(x,y) <= dist){
                result.add(darkStore);
            }
        }

        return result;
    }

    public DeliveryPartner getDeliveryPartner(DarkStore darkStore){
        // GET ALL DELIVERY PARTNERS NEARBY TO DARK STORE AND ASSIGN THE ONE WITH HIGHEST RATING
        if(darkStore.getName().equalsIgnoreCase("Rajendra nagar")){
            return new DeliveryPartner("Rohit",4.5);
        }
        else if(darkStore.getName().equalsIgnoreCase("Lajpat nagar")){
            return new DeliveryPartner("Harsh",4.5);
        }
        else if(darkStore.getName().equalsIgnoreCase("IVRI")){
             return new DeliveryPartner("yatharth",3.5);
        }
        else{
            return new DeliveryPartner("Akram",3.0);
        }
    }

}
