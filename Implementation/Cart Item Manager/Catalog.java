package CartItemManager;

import CustomerService.Database;

public class Catalog {


    // function to display the catalog of items loaded from the database
    public void displayCatalog() {
        Database database = new Database();
        for (Item item : Database.catalog) {
            System.out.println("[Name: " + item.getName() + ",Price:  " + item.getPrice() + " ,Brand: " +
                    item.getBrand() + " ,Discount: " + item.getDiscountPercentage() +
                    " ,Number of Units: " + item.getNumberOfUnits() + "]");
        }


    }
}
