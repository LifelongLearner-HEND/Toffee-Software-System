package MembershipManager;

import static CustomerService.Database.Registered_Users;

public class Login {

    public void authenticate(String id, String password) {
        // check if the id already exists in the database
        if (Registered_Users.containsKey(id)) {
            if (Registered_Users.get(id).equals(password)) {
                System.out.println("User logged in successfully");
            } else {
                System.out.println("Wrong password");
            }
        } else {
            System.out.println("User doesn't exist");
        }
    }

}
