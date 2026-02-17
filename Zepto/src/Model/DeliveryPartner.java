package Model;

public class DeliveryPartner {

    private String name;
    private Double rating;
    private Double x,y;

    public DeliveryPartner(String name, Double rating){
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Double getRating() {
        return rating;
    }
}
