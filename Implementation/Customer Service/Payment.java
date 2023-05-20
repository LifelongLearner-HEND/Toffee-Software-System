package CustomerService;

/**
 * this class is the abstract class for payment process
 */
public abstract class Payment {

    double shippingCost;

    /**
     * this is the constructor for the payment class, it will set the shipping cost to 9.99
     */
    public Payment() {
        shippingCost = 9.99;
    }

    /**
     * this method is used to get the shipping cost
     * @return
     */
    public abstract  double getTotalAmount();

}