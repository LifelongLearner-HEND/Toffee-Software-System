package CustomerService;

import CartItemManager.Item;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is used to store the data of the system
 */

public class Database {
    public static HashMap<String, String> Registered_Users = new HashMap<String, String>();

    public static HashMap<String, String> Customers_Phone = new HashMap<String, String>();

    public static HashMap<String, String> Customers_Address = new HashMap<String, String>();

    public static HashMap<String, String> Customers_Email = new HashMap<String, String>();

    public static ArrayList<Item> catalog = new ArrayList<Item>();

    /**
     * this is the constructor for the database class, it will initialize the data, it will add the registered users to the map, it will add the items to the catalog
     *
     */
    public Database() {
        // map of registered users (key --> ID, value --> password)
        Registered_Users.put("0994536", "Aa1236$$");
        Registered_Users.put("0994530", "Bb6985**");
        Registered_Users.put("0994789", "CDd1256#1");
        Registered_Users.put("0992125", "AaBb*c123");
        Registered_Users.put("0996419", "Qq1234@#2");
        Registered_Users.put("0993328", "JPG1234@#2");
        // map of customers' phone numbers (key --> ID, value --> phone number)
        Customers_Phone.put("0994536", "01114589325");
        Customers_Phone.put("0994530", "01578412569");
        Customers_Phone.put("0994789", "01200145896");
        Customers_Phone.put("0992125", "01025412590");
        Customers_Phone.put("0996419", "01236521458");
        Customers_Phone.put("0993328", "01520148500");
        // map of customers' addresses (key --> ID, value --> address)
        Customers_Address.put("0994536", "8 Zwail st.");
        Customers_Address.put("0994530", "10 Giza st.");
        Customers_Address.put("0994789", "12 Cairo st.");
        Customers_Address.put("0992125", "14 Alexandria st.");
        Customers_Address.put("0996419", "16 Mansoura st.");
        // map of customers' email (key --> ID, value --> email)
        Customers_Email.put("0994536", "ahmed@gmail.com");
        Customers_Email.put("0994530", "ali@gmail.com");
        Customers_Email.put("0994789", "Marwa@gmail.com");
        Customers_Email.put("0992125", "Omar@gmail.com");
        Customers_Email.put("0996419", "Hoor@gmail.com");
        // catalog of items
        Item item1 = new Item("Caramel", 100, 10.0, "Cadbury", 3.0);
        Item item2 = new Item("Milk", 70, 20.0, "Ferrero Rocher", 0.0);
        Item item3 = new Item("Dark Chocolate", 80, 30.0, "Walkers", 5.0);
        Item item4 = new Item("Nougat", 90, 40.0, "Skor", 10.0);
        Item item5 = new Item("White Chocolate", 60, 30.0, "Lindt", 0.0);
        Item item6 = new Item("Caramelized nuts", 70, 50.0, "Hershey's", 0.0);
        Item item7 = new Item("Brittle", 80, 60.0, "Toblerone", 5.0);
        Item item8 = new Item("Macarons", 200, 70.0, "Milka", 10.0);
        Item item9 = new Item("Mochi", 100, 10.0, "Cadbury", 3.0);
        Item item10 = new Item("Tiramisu", 99, 10.0, "Cadbury", 3.0);
        // add all the items to the catalog
        catalog.add(item1);
        catalog.add(item2);
        catalog.add(item3);
        catalog.add(item4);
        catalog.add(item5);
        catalog.add(item6);
        catalog.add(item7);
        catalog.add(item8);
        catalog.add(item9);
        catalog.add(item10);
    }
}