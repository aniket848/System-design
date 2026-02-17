package Model;

public class User {
    private static Integer userId = 1;
    private Integer id;
    private String name;
    private Double x,y;
    private Cart cart;

    public User(String name,Double xCoord,Double yCoord){
        this.id = userId++;
        this.name = name;
        this.x = xCoord;
        this.y = yCoord;
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Cart getCart() {
        return cart;
    }
}
