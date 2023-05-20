import CustomerService.Database;

/**
 * this is the main class for the application
 */
public class Main {
    public static void main(String[] args) {
        Application app = new Application() {};
        Database database = new Database();
        app.run();
    }
}