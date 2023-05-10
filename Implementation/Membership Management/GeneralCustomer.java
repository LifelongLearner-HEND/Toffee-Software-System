package MembershipManager;

import CartItemManager.Item;

import static CustomerService.Database.catalog;

public class GeneralCustomer {

    public void viewCatalog() {
//        Database database = new Database();
        for (Item item : catalog) {
            System.out.println("[Name: " + item.getName() + ",Price:  " + item.getPrice() + " ,Brand: " +
                    item.getBrand() + " ,Discount: " + item.getDiscountPercentage() +
                    " ,Number of Units: " + item.getNumberOfUnits() + "]");
        }
    }

    public void registerUser(RegisteredCustomer customer) {
        Register joinSystem = new Register();
        joinSystem.register(customer);
    }
}
