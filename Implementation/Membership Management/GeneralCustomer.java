package MembershipManager;

import CartItemManager.Item;

import static CustomerService.Database.catalog;

public class GeneralCustomer {
    /**
     * this method is used to view the catalog
     */

    public void viewCatalog() {
        for (Item item : catalog) {
            System.out.println("[Name: " + item.getName() + " | Price:  " + item.getPrice() + " | Brand: " +
                    item.getBrand() + " | Discount: " + item.getDiscountPercentage() +
                    " | Number of Units: " + item.getNumberOfUnits() + "]");
        }
    }

    /**
     * this method is to register a new user
     * @param customer
     */
    public void registerUser(RegisteredCustomer customer) {
        Register joinSystem = new Register();
        joinSystem.register(customer);
    }
}