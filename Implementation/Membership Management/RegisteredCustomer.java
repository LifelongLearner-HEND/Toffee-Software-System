package MembershipManager;

/**
 * This class is used to register a new user to the store database.
 */
public class RegisteredCustomer extends GeneralCustomer{
    private String id;
    private String password;
    private String address;
    private String phoneNumber;
    private String email;

    /**
     * This method is the class constructor, it is used to initialize the class attributes
     * @param id
     * @param password
     * @param address
     * @param phoneNumber
     * @param email
     */
    public RegisteredCustomer (String id, String password, String address, String phoneNumber, String email) {
        this.id = id;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * default constructor
     */
    public RegisteredCustomer() {

    }

    /**
     * This method is used to login to the system, It will call the authenticate method from the Login class, If the user is authenticated, it will return true
     * @param ID
     * @param pass
     * @return
     */
    // login to the system
    public boolean login(String ID, String pass) {
        Login login = new Login();
        return login.authenticate(ID, pass);
    }

    /**
     * This method is used to set the user's id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method is used to set the user's password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method is used to set the user's address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method is used to set the user's phone number
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method is used to set the user's email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method is used to get the user's id
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * This method is used to get the user's password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method is used to get the user's address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method is used to get the user's phone number
     * @return
     */
    public String getPhoneNumber() { return phoneNumber;}

    /**
     * This method is used to get the user's email
     * @return
     */
    public String getEmail() {
        return email;
    }
}