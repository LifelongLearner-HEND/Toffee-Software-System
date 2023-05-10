package CustomerService;

import CartItemManager.Cart;
import CartItemManager.Item;
import MembershipManager.RegisteredCustomer;

import static CustomerService.Database.Customers_Address;
import static CustomerService.Database.Customers_Phone;

public class Order {
    private String orderStatus;
    private double totalPrice;

    private RegisteredCustomer customer;
    private Cart cart;

    public Order( RegisteredCustomer customer, Cart cart, String orderStatus, double totalPrice) {
        this.customer = customer;
        this.cart = cart;
        this.orderStatus = "Pending";
        this.totalPrice = 0.0;
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
        // get the phone number of the customer from the Customers_Phone database according to the customer id
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Phone Number: " + Customers_Phone.get(customer.getId()));
        System.out.println("Customer Address: " + Customers_Address.get(customer.getId()));
        System.out.println("Order Status: " + orderStatus);
    }
}
