package model;

public class cartItem {

    private Product product;
    private int quantity;

    public cartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getPrice(){
        return product.getPrice()* quantity;
    }

    public Product getProduct() {
        return product;
    }
}
