package model;

public class MenuItem {

    private Integer itemId;
    private String name;
    private Double price;

    public MenuItem(){

    }

    public MenuItem(Integer itemId, String name, Double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
