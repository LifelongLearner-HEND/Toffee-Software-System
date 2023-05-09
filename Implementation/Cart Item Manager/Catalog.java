package CartItemManager;

import static CustomerService.Database.catalog;


public class Catalog {

    // function to display the catalog of items loaded from the database
    public void displayCatalog() {
        // display the catalog of items loaded from the database
        for (Item item : catalog) {
            System.out.println("[Name: " + item.getName() + ",Price:  " + item.getPrice() + " ,Brand: " +
                                item.getBrand() + " ,Discount: " + item.getDiscountPercentage() +
                                " ,Number of Units: " + item.getNumberOfUnits() + "]");
        }
    }
}
