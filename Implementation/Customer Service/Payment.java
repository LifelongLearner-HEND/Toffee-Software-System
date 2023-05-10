package CustomerService;

public abstract class Payment {

    double shippingCost;

    public Payment() {
        shippingCost = 9.99;
    }

    public abstract  double getTotalAmount();

}
