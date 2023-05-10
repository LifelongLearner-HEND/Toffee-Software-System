package MembershipManager;

import static CustomerService.Database.*;

public class Register {

    // make the user register and then push their data to the database
    public void register(RegisteredCustomer customer) {
        // check if the id already exists in the database
        if (Registered_Users.containsKey(customer.getId())) {
            System.out.println("User already exists");
        }
        else {
            Registered_Users.put(customer.getId(), customer.getPassword());
            Customers_Address.put(customer.getId(), customer.getAddress());
            Customers_Phone.put(customer.getId(), customer.getPhoneNumber());
            Customers_Email.put(customer.getId(), customer.getEmail());
            System.out.println("User registered successfully");
        }
    }
}
