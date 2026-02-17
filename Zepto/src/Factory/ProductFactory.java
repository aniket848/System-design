package Factory;

import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductFactory {

    private static ProductFactory instance = null;
    private HashMap<Integer, String> productName;
    private HashMap<Integer, Double> productPrice;
    private List<Product> productList = new ArrayList<>();

    private ProductFactory(){
        productName = new HashMap<>();
        productPrice = new HashMap<>();

        // Sample products
        productName.put(1001, "Laptop");
        productPrice.put(1001, 999.0);

        productName.put(1002, "Smartphone");
        productPrice.put(1002, 499.0);

        productName.put(1003, "Headphones");
        productPrice.put(1003, 199.99);

        productName.put(1004, "Sweater");
        productPrice.put(1004, 529.0);

        productName.put(1005, "Jacket");
        productPrice.put(1005, 1000.0);

        productName.put(1006, "Bicycle");
        productPrice.put(1006, 5000.0);

    }

    public static ProductFactory getInstance(){
        if(instance == null){
            instance = new ProductFactory();
        }
        return instance;
    }

    public Product createProduct(Integer sku){
         String name = productName.get(sku);
         Double price = productPrice.get(sku);

         Product p =  new Product(sku, name, price);
         this.productList.add(p);
         return p;
    }

    public Product getProduct(Integer sku){
        for(Product p : productList){
            if(p.getSku().equals(sku)){
                return p;
            }
        }
        return null;
    }


}
