package CartItemManager;

import java.util.HashMap;
import static CustomerService.Database.catalog;

/**
 * This class is used to manage the cart items,It will add, remove, search for items in the cart, It will also check if the quantity is valid, It will also check if the item is available in the catalog or not, It will also check if the cart is empty or not, It will also check if the item is available in the cart or not
 */
public class Cart {
    private HashMap<Item, Integer> cartItems = new HashMap<Item, Integer>();

    /**
     * This method is used to add item to the cart, It will check if the item is available in the catalog or not, If yes, it will check if the quantity is valid or not, If yes, it will check if the item is available in the catalog or not, If yes, it will add the item to the cart
     * @param name
     * @param quantity
     */
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

    /**
     * This method is used to check if the cart is empty or not
     * @return
     */
    public boolean isEmpty() {
        return (cartItems.size() == 0);
    }

    /**
     * This method is used to remove item from the cart, It will check if the cart is empty or not, If yes, it will check if the item is available in the cart or not, If yes, it will remove the item from the cart, If no, it will print out the message "Item not found!!"
     * @param name
     */
    public void removeItem(String name) {
        if (isEmpty()) {
            System.out.println("Cart is empty!!");
            return;
        }
        else if (searchOnCart(name) != null) {
            cartItems.remove(searchOnCart(name));
        }
        else {
            System.out.println("Item not found!!");
        }
    }
    /**
     * This method is used to search for item in the catalog
     * @param itemName
     * @return
     */
    public Item searchOnCatalog(String itemName) {
        for (Item item : catalog) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    /**
     * This method is used to search for item in the cart
     * @param name
     * @return
     */
    public Item searchOnCart(String name) {
        for (Item item : cartItems.keySet()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * This method is used to check if the quantity is valid or not( between 1 and 50)
     * @param quantity
     * @return
     */
    private boolean isValidQuantity(int quantity) {
        return (quantity > 0 && quantity <= 50);
    }

    /**
     * This method is used to check if the item is available in the catalog or not
     * @param item
     * @param quantity
     * @return
     */
    private boolean isAvailable(Item item, int quantity) {
        return (item.getNumberOfUnits() >= quantity);
    }

    /**
     * This method is used to get the cart items
     * @return
     */
    public HashMap<Item, Integer> getCartItems() {
        return cartItems;
    }
}