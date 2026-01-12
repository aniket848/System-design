package strategy;

public class CreditCardPayment implements Payment{

    private String creditCardNo;

    public CreditCardPayment(String no){
        this.creditCardNo = no;
    }

    @Override
    public void pay(double totalPrice) {
        System.out.println("Payment of rupees "+ totalPrice + " has been done through credit card no: "+ this.creditCardNo);
    }
}
