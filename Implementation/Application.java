import CartItemManager.Cart;
import CustomerService.CashPayment;
import CustomerService.Order;
import MembershipManager.GeneralCustomer;
import MembershipManager.RegisteredCustomer;
import MembershipManager.OTPgenerated;


import java.util.Scanner;

/**
 * This class is used to run the application, It will call the methods from other classes to perform the required operations, It will also display the menu for the user to choose from, It will also take the user's input and pass it to the required method, the output of the method, error messages if any, the OTP generated for the user, the order data, the total amount of the order, the shipping cost
 */
public interface Application {

    Scanner input = new Scanner(System.in);

    /**
     * This method is used to run the application, It will call the methods from other classes to perform the required operations
     */
    public default void GeneralCustomerMenu() {
        System.out.println("1. View Catalog");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }

    /**
     * This method is used to display the menu for the registered user, It will also take the user's input and pass it to the required method, It will also display the output of the method, It will also display the error messages
     */
    public default void RegisteredCustomerMenu() {
        System.out.println("1. View Catalog");
        System.out.println("2. Add to Cart");
        System.out.println("3. Remove from Cart");
        System.out.println("4. Checkout"); // print order data
        System.out.println("5. Exit");
    }

    /**
     * This method is used to display the menu for the general user, It will also take the user's input and pass it to the required method and display the output of the method, check if the validation of input is correct or not before passing it to the required method
     */
    public default void GeneralUser() {
        GeneralCustomerMenu();
        GeneralCustomer gCustomer = new GeneralCustomer();
        System.out.println("Enter your choice: ");
        int userChoice = Integer.parseInt(input.nextLine());
        while (userChoice != 3) {
            // view catalog
            if (userChoice == 1) {
                gCustomer.viewCatalog();
                // register to the system
            } else if (userChoice == 2) {
                RegisteredCustomer customer = new RegisteredCustomer();
                String id, password, address, phoneNumber, email;
                System.out.println("Enter your username: ");
                id = input.nextLine();
                while(!id.matches("^[A-Za-z0-9_]+$")){
                    System.out.println("Invalid Format, Please re-enter the username: ");
                    id = input.nextLine();
                }
                System.out.println("Enter your email: ");
                email = input.nextLine();
                while(!email.matches("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$")){
                    System.out.println("Invalid Format, Please re-enter the email: ");
                    email = input.nextLine();
                }
                customer.setEmail(email);
                OTPgenerated.sendOTP(email);
                String OTPCheker = OTPgenerated.getOTP();
                System.out.println("Enter OTP: ");
                String enteredOTP = input.nextLine();
                while (!enteredOTP.equals(OTPCheker)){
                    System.out.println("Invalid OTP");
                    enteredOTP = input.nextLine();
                }
                customer.setId(id);
                System.out.println("Enter your password in the format [0-9/Aa/&%]: ");
                password = input.nextLine();
                while(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&_])[A-Za-z\\d@$!%*?&_]{8,}$")){
                    System.out.println("Invalid Format, Please re-enter the password: ");
                    password = input.nextLine();
                }
                customer.setPassword(password);
                System.out.println("Enter your address: ");
                address = input.nextLine();
                customer.setAddress(address);
                System.out.println("Enter your phone number: ");
                phoneNumber = input.nextLine();
                while(!phoneNumber.matches("^(011|012|010|015)\\d{8}$")){
                    System.out.println("Invalid Format, Please re-enter the phone number: ");
                    phoneNumber = input.nextLine();
                }
                customer.setPhoneNumber(phoneNumber);

                gCustomer.registerUser(customer);
                LoggedUser();

            } else {
                System.out.println("Invalid choice");
            }
            System.out.println("Enter your choice: ");
            userChoice = input.nextInt(); // Read user's choice again
        }
    }

    /**
     * This method is used to display the menu for the logged user, It will also take the user's input and pass it to the required method and display the output of the method, check if the validation of input is correct or not before passing it to the required method, check if the user is logged in or not
     */
    public default void LoggedUser() {
        RegisteredCustomerMenu();
        boolean logged = false;
        RegisteredCustomer customer = new RegisteredCustomer();
        Cart cart = new Cart();
        System.out.println("Login first to your account");
        System.out.println("Enter your username: ");
        String id = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        customer.setId(id);
        customer.setPassword(password);
        logged = customer.login(id, password);
        if (logged) {
            System.out.println("Enter your choice: ");
            int userChoice = Integer.parseInt(input.nextLine());
            while (userChoice != 5) {
                if (userChoice == 1) {
                    customer.viewCatalog();
                } else if (userChoice == 2) {
                    System.out.println("Enter number of items you want to add: ");
                    int n = input.nextInt();
                    for (int i = 0; i < n; i++) {
                        String itemName;
                        int quantity;
                        System.out.println("Enter item name: ");
                        itemName = input.next();
                        System.out.println("Enter quantity: ");
                        quantity = input.nextInt();
                        cart.addItem(itemName, quantity);
                    }
                } else if (userChoice == 3) {
                    System.out.println("Enter number of items you want to remove: ");
                    int n = input.nextInt();
                    for (int i = 0; i < n; i++) {
                        String itemName;
                        System.out.println("Enter item name: ");
                        itemName = input.next();
                        cart.removeItem(itemName);
                    }
                } else if (userChoice == 4) {
                    Order order = new Order(customer, cart, "Pending", 0.0);
                    CashPayment cashPayment = new CashPayment(order);
                    order.displayOrder();
                    System.out.println("Total price: " + cashPayment.getTotalAmount());
                } else {
                    System.out.println("Invalid choice");
                }
                System.out.println("Enter your choice: ");
                userChoice = input.nextInt(); // Read user's choice again
            }
        }
        else {
            System.out.println("Invalid id or password");
        }
    }

    /*
     * This method is used to display the main menu for the general user, It will also take the user's input and pass it to the required method and display the output of the method, it gives the user the choice to register or login or exit
     */

    public default void run() {
        int userChoice;
        System.out.println("Welcome to our store");
        System.out.println("Press 1 if you are a general customer");
        System.out.println("Press 2 if you are a registered customer");
        System.out.println("Press 3 to exit");
        System.out.println("Enter your choice: ");
        userChoice = Integer.parseInt(input.nextLine());
        while (userChoice != 3) {
            if (userChoice == 1) {
                GeneralUser();
            }
            else if (userChoice == 2) {
                LoggedUser();
            }
            else {
                System.out.println("Invalid choice");
            }
            System.out.println("Press 1 if you are a general customer");
            System.out.println("Press 2 if you are a registered customer");
            System.out.println("Press 3 to exit");
            System.out.println("Enter your choice: ");
            userChoice = input.nextInt();
        }
    }
}