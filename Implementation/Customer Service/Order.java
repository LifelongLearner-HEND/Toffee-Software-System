package CustomerService;

import CartItemManager.Cart;
import MembershipManager.RegisteredCustomer;
import CartItemManager.Item;
import static CustomerService.Database.Customers_Data;

public class Order {
    private String orderStatus;
    private double totalPrice;

    private RegisteredCustomer customer;
    private Cart cart;

    private CashPayment payment;

    public Order(RegisteredCustomer customer, Cart cart, String orderStatus, double totalPrice) {
        this.orderStatus = "Pending";
        this.totalPrice = 0.0;
        this.customer = customer;
        this.cart = cart;
    }

    public double calAmount() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!!");
            return 0.0;
        }
         // calculate total price of the order by summing the price of each item in the cart multiplied by its quantity
        for (Item item : cart.getCartItems().keySet()) {
            totalPrice += item.getPrice() * cart.getCartItems().get(item);
        }
        return totalPrice;
    }


    public void displayOrder() {
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Phone Number: " + Customers_Data.get(customer.getId()).getPhoneNumber());
//        System.out.println("Customer Address: " + Database.getCustomerAddress(customer.getId()));
        System.out.println("Order Status: " + orderStatus);
//        System.out.println("Total Price: " + payment.totalPrice());
    }
}
