package CustomerService;

public class CashPayment extends Payment{

    private Order price;

    public CashPayment(double shippingCost) {
        super(shippingCost);
    }
    public double totalPrice(){
        return price.calAmount() + super.getShippingCost();
    }
}
