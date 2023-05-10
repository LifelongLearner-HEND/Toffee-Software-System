package CustomerService;

public class CashPayment extends Payment{

    Order order;
    public CashPayment(Order order) {
        super();
        this.order = order;
    }

    public double getShippingCost() {
        return super.shippingCost;
    }

    @Override
    public double getTotalAmount() {
        // total amount = total price of the order + shipping cost
        return order.calAmount() + getShippingCost();
    }


}
