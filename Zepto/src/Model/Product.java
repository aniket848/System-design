package Model;

public class Product {
    private String name;
    private Integer sku;
    private Double price;

    public Product(Integer sku,String name, Double price) {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getSku() {
        return sku;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
