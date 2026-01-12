package strategy;

public class UPIPayment implements Payment{

    private String mobileNo;

    public UPIPayment(String mobile){
        this.mobileNo = mobile;
    }

    @Override
    public void pay(double totalPrice) {
        System.out.println("Payment of rupees "+ totalPrice + " has been done UPI no: "+ this.mobileNo);
    }
}
