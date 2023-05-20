package CartItemManager;

/**
 * this class is the item class, it will store the information of the item
 */
public class Item {
    private String name;
    private int numberOfUnits;
    private double price;
    private String brand;
    private double discountPercentage;

    /**
     * this is the constructor of the item class
     * @param name
     * @param numberOfUnits
     * @param price
     * @param brand
     * @param discountPercentage
     */
    public Item(String name, int numberOfUnits, double price, String brand, double discountPercentage) {
        this.name = name;
        this.numberOfUnits = numberOfUnits;
        this.price = price;
        this.brand = brand;
        this.discountPercentage = discountPercentage;
    }

    /**
     * this method is used to get the name of the item
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * this method is used to get the number of units of the item
     * @return
     */
    public int getNumberOfUnits() {
        return numberOfUnits;
    }
    /**
    * this method is used to get the price of the item
    * @return
    */
    public double getPrice() {
        return price;
    }

    /**
     * this method is used to get the brand of the item
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * this method is used to get the discount percentage of the item
     * @return
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }

}