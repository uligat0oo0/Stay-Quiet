package androides.stayquiet;

import java.io.Serializable;

/**
 * Created by developer on 15/10/17.
 */

public class User implements Account, Serializable {
    private String firstName, lastName, phoneNumber, email, password;

    public User(String firstName, String lastName, String phoneNumber, String email,
                String password) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setPassword(password);
    }

    public User(String email, String password) {
        super();
        setFirstName("");
        setLastName("");
        setPhoneNumber("");
        setEmail(email);
        setPassword(password);
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public int createAccount() {
        return 0;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
