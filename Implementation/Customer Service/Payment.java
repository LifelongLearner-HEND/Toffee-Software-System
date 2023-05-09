package CustomerService;

public abstract class Payment {

    private final double shippingCost;


    public Payment(double shippingCost) {
        this.shippingCost = 9.99;
    }
    // add abstract method to calculate the total price of the order
    public abstract double totalPrice();

    protected double getShippingCost() {
        return shippingCost;
    }
}
