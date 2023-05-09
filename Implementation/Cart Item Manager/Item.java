package CartItemManager;

public class Item {
    private String name;
    private int numberOfUnits;
    private double price;
    private String brand;
    private double discountPercentage;

    public Item(String name, int numberOfUnits, double price, String brand, double discountPercentage) {
        this.name = name;
        this.numberOfUnits = numberOfUnits;
        this.price = price;
        this.brand = brand;
        this.discountPercentage = discountPercentage;
    }
    public String getName() {
        return name;
    }
    public int getNumberOfUnits() {
        return numberOfUnits;
    }
    public double getPrice() {
        return price;
    }
    public String getBrand() {
        return brand;
    }
    public double getDiscountPercentage() {
        return discountPercentage;
    }

}
