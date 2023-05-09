package CustomerService;

import CartItemManager.Item;
import MembershipManager.RegisteredCustomer;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    public static HashMap<String, String> Registered_Users = new HashMap<String, String>();

    public static HashMap<String, RegisteredCustomer> Customers_Data = new HashMap<String, RegisteredCustomer>();

    public static ArrayList<Item> catalog = new ArrayList<Item>();

    public Database() {
        // map of registered users (key --> ID, value --> password)

        Registered_Users.put("0994536", "aa2832");
        Registered_Users.put("0994530", "aa2832");
        Registered_Users.put("0994789", "aa226b");
        Registered_Users.put("0992125", "aa223c");
        Registered_Users.put("0996419", "Ox2569");
        Registered_Users.put("0993328", "jp2569");

        // create hashmap which its key is the previous is and the value is the customer object
        RegisteredCustomer customer1 = new RegisteredCustomer("0994536", "aa2832", " 5 Zwail", "0777888", "ahmed@mail.com");
        RegisteredCustomer customer2 = new RegisteredCustomer("0994530", "aa2832", " 6 Zwail", "0777877", "ali@mail.com");

        Customers_Data.put("0994536", customer1);
        Customers_Data.put("0994530", customer2);


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
