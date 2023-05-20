package CustomerService;

/**
 * this class is the abstract class for payment process
 */
public class CashPayment extends Payment{
    /**
     * this is the constructor for the payment class
     */
    Order order;
    public CashPayment(Order order) {
        super();
        this.order = order;
    }

    /**
     * this method is used to get the shipping cost
     * @return
     */
    public double getShippingCost() {
        return super.shippingCost;
    }

    /**
     * this method is used to get the total amount
     * @return
     */
    @Override
    public double getTotalAmount() {
        // total amount = total price of the order + shipping cost
        return order.calAmount() + getShippingCost();
    }
}