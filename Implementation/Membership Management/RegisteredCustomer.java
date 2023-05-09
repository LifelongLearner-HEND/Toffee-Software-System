package MembershipManager;

public class RegisteredCustomer extends GeneralCustomer{
    private String id;
    private String password;
    private String address;
    private String phoneNumber;
    private String email;

    public RegisteredCustomer (String id, String password, String address, String phoneNumber, String email) {
        this.id = id;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public RegisteredCustomer() {

    }

    // login to the system
    public void login(String ID, String pass) {
        Login login = new Login();
        login.authenticate(ID, pass);
    }
    public void makeOrder() {
        // make an order
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAddress(String address) {
    }
    public void setPhoneNumber(String phoneNumber) {
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}