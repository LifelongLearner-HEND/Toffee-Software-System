package MembershipManager;

import static CustomerService.Database.Registered_Users;

public class Login {
    /**
     * this method is used to authenticate the user, if the user is already registered.
     * @param id
     * @param password
     * @return
     */
    public boolean authenticate(String id, String password) {
        // check if the id already exists in the database
        if (Registered_Users.containsKey(id)) {
            if (Registered_Users.get(id).equals(password)) {
                System.out.println("User logged in successfully");
                return true;
            } else {
                System.out.println("Wrong password");
                return false;
            }
        } else {
            System.out.println("User doesn't exist");
            return false;
        }
    }
}