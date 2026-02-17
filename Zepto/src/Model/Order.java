package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {

    private static Integer id = 1;
    private Integer orderId;
    private User user;
    private HashMap<Product,Integer> productList;
    private List<DeliveryPartner> deliveryPartnerList;
    private Double totalPrice;

    public Order(){
        this.orderId = id++;
        this.productList = new HashMap<>();
        this.deliveryPartnerList = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void addProduct(Product product, Integer quantity){
        this.productList.put(product,quantity);
        this.totalPrice += product.getPrice()*quantity;
    }

    public void addDeliveryPartner(DeliveryPartner deliveryPartner){
        this.deliveryPartnerList.add(deliveryPartner);
    }

    public Double getTotalPrice(){
        return this.totalPrice;
    }

    public HashMap<Product,Integer> getProductList(){
        return this.productList;
    }

    public List<DeliveryPartner> getDeliveryPartnerList() {
        return deliveryPartnerList;
    }
}
