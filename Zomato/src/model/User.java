package model;

public class User {

    private Integer userId;
    private String name;
    private String address;
    private Cart cart;

    public User(Integer userId, String name){
        this.name = name;
        this.userId = userId;
        this.cart = null;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
