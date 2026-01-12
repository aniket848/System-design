package model;

import java.util.List;

public class Restaurant {

    private static Integer nextRestaurantId = 0;
    private Integer id;
    private String name;
    private List<MenuItem> menuList;
    private String location;

    public Restaurant(String name, String location){
        this.name = name;
        this.location = location;
        this.id = ++nextRestaurantId;
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
