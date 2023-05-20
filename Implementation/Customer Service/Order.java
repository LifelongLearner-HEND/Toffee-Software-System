package CustomerService;

import CartItemManager.Cart;
import CartItemManager.Item;
import MembershipManager.RegisteredCustomer;

import static CustomerService.Database.Customers_Address;
import static CustomerService.Database.Customers_Phone;

/**
 * this class is the order class
 */
public class Order {
    private String orderStatus;
    private double totalPrice;

    private RegisteredCustomer customer;
    private Cart cart;

    /**
     * this is the constructor of the order class, it will set the order status to pending, it will set the total price to 0.0
     * @param customer
     * @param cart
     * @param orderStatus
     * @param totalPrice
     */
    public Order( RegisteredCustomer customer, Cart cart, String orderStatus, double totalPrice) {
        this.customer = customer;
        this.cart = cart;
        this.orderStatus = "Pending";
        this.totalPrice = 0.0;
    }

    /**
     * this method is used to calculate the total price of the order
     * @return
     */
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

    /**
     * this method is used to display the order details
     */
    public void displayOrder() {
        // get the phone number of the customer from the Customers_Phone database according to the customer id
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Phone Number: " + Customers_Phone.get(customer.getId()));
        System.out.println("Customer Address: " + Customers_Address.get(customer.getId()));
        System.out.println("Order Status: " + orderStatus);
    }
}