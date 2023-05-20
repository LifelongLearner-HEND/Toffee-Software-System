package MembershipManager;

import static CustomerService.Database.*;

/**

 * This class is used to register a new user to the store database.
 */
public class Register {
    /**
     * This method is used to register a new user, It will check if the user already exists in the database, If not, it will push the user's data to the database, If yes, it will print out a message saying that the user already exists, The user will be asked to re-enter their data
     * @param customer
     */
    // make the user register and then push their data to the database
    public void register(RegisteredCustomer customer) {
        // check if the id already exists in the database
        if (Registered_Users.containsKey(customer.getId())) {
            System.out.println("User already exists!!");
        }
        else {
            Registered_Users.put(customer.getId(), customer.getPassword());
            Customers_Address.put(customer.getId(), customer.getAddress());
            Customers_Phone.put(customer.getId(), customer.getPhoneNumber());
            Customers_Email.put(customer.getId(), customer.getEmail());
            System.out.println("User registered successfully ☺");
        }
    }
}