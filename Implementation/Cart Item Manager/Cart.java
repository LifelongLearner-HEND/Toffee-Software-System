package CartItemManager;

import java.util.HashMap;
import static CustomerService.Database.catalog;

public class Cart {
    private HashMap<Item, Integer> cartItems = new HashMap<Item, Integer>();

    public void addItem(String name, int quantity) {
        Item item = searchOnCatalog(name);
        if (item != null) {
            if (isValidQuantity(quantity) && isAvailable(item, quantity)) {
                cartItems.put(item, quantity);
//                System.out.println("Item added to cart successfully ☺");
            }
            else {
                System.out.println("Invalid quantity!!");
            }
        }
        else {
            System.out.println("Item not found!!");
        }
    }
    public boolean isEmpty() {
        return (cartItems.size() == 0);
    }
    public void removeItem(String name) {
        if (isEmpty()) {
            System.out.println("Cart is empty!!");
            return;
        }
        if (searchOnCart(name) != null) {
            cartItems.remove(searchOnCart(name));
//            System.out.println("Item removed from cart successfully ☺");
        }
        else {
            System.out.println("Item not found!!");
        }
    }
    public Item searchOnCatalog(String itemName) {
        for (Item item : catalog) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Item searchOnCart(String name) {
        for (Item item : cartItems.keySet()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    private boolean isValidQuantity(int quantity) {
        return (quantity > 0 && quantity <= 50);
    }

    private boolean isAvailable(Item item, int quantity) {
        return (item.getNumberOfUnits() >= quantity);
    }

    public HashMap<Item, Integer> getCartItems() {
        return cartItems;
    }
}
