package project.demo2.User;

import jdk.jfr.Event;
import project.demo2.Event.EventInfo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class UserInfo {
    @Id
    @SequenceGenerator(
            name = "UserInfo_sequence", sequenceName = "UserInfo_sequence", allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "UserInfo_sequence"
    )
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;


    public UserInfo() {

    }

    public UserInfo(String userName, String email, String password, String firstName, String lastName) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
