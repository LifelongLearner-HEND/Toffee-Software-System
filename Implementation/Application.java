import CartItemManager.Cart;
import CartItemManager.Catalog;
import CustomerService.CashPayment;
import CustomerService.Order;
import MembershipManager.GeneralCustomer;
import MembershipManager.RegisteredCustomer;

import java.util.Scanner;

public interface Application {

//    public default void Application() {
//        Database database = new Database();
//    }


    Scanner input = new Scanner(System.in);

    public default void GeneralCustomerMenu() {
        System.out.println("1. View Catalog");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }
    public default void RegisteredCustomerMenu() {
        System.out.println("1. Login");
        System.out.println("2. View Catalog");
        System.out.println("3. Add to Cart");
        System.out.println("4. Remove from Cart");
        System.out.println("5. Checkout"); // print order data
        System.out.println("6. Exit");
    }
    public default void GeneralUser() {
        GeneralCustomerMenu();
        GeneralCustomer gCustomer = new GeneralCustomer();
        System.out.println("Enter your choice: ");
        int userChoice = input.nextInt();
        while (userChoice != 3) {
            if (userChoice == 1) {
                Catalog catalog = new Catalog();
                catalog.displayCatalog();
            } else if (userChoice == 2) {
                RegisteredCustomer customer = new RegisteredCustomer();
                String id, password, address, phoneNumber, email;
                System.out.println("Enter your id: ");
                id = input.next();
                customer.setId(id);
                System.out.println("Enter your password: ");
                password = input.next();
                customer.setPassword(password);
                System.out.println("Enter your address: ");
                address = input.next();
                customer.setAddress(address);
                System.out.println("Enter your phone number: ");
                phoneNumber = input.next();
                customer.setPhoneNumber(phoneNumber);
                System.out.println("Enter your email: ");
                email = input.next();
                customer.setEmail(email);
                gCustomer.registerUser(customer);
                LoggedUser();
            } else {
                System.out.println("Invalid choice");
            }
            System.out.println("Enter your choice: ");
            userChoice = input.nextInt(); // Read user's choice again
        }
    }

    public default void LoggedUser() {
        RegisteredCustomerMenu();
        boolean logged = false;
        RegisteredCustomer customer = new RegisteredCustomer();
        Cart cart = new Cart();
        System.out.println("Enter your choice: ");
        int userChoice = input.nextInt();
        while (userChoice != 6) {
            if (userChoice == 1) {
                System.out.println("Enter your id: ");
                String id = input.next();
                System.out.println("Enter your password: ");
                String password = input.next();
                customer.setId(id);
                customer.setPassword(password);
                logged = customer.login(id, password);
            }
            else if (userChoice == 2 && logged) {
                customer.viewCatalog();
            } else if (userChoice == 3 && logged) {
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

            } else if (userChoice == 4 && logged) {
                System.out.println("Enter number of items you want to remove: ");
                int n = input.nextInt();
                for (int i = 0; i < n; i++) {
                    String itemName;
                    System.out.println("Enter item name: ");
                    itemName = input.next();
                    cart.removeItem(itemName);
                }
            } else if (userChoice == 5 && logged) {
                Order order = new Order(customer, cart,"Pending", 0.0);
                CashPayment cashPayment = new CashPayment(order);
                order.displayOrder();
                System.out.println("Total price: " + cashPayment.getTotalAmount());
            }
            else {
                System.out.println("Invalid choice");
            }
            System.out.println("Enter your choice: ");
            userChoice = input.nextInt(); // Read user's choice again
        }
    }



    public default void run() {
        int userChoice;
        System.out.println("Welcome to our store");
        System.out.println("Press 1 if you are a general customer");
        System.out.println("Press 2 if you are a registered customer");
        System.out.println("Press 3 to exit");
        userChoice = input.nextInt();
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
            userChoice = input.nextInt();
        }
    }
}