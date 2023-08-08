package ua.com.poseal.todo.domain;

import org.springframework.stereotype.Component;
import ua.com.poseal.todo.util.IPNCheck;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @IPNCheck
    private String ipn;

    public User() {
    }

    public User(String firstName, String lastName, String ipn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ipn = ipn;
    }

    public User(Long id, String firstName, String lastName, String ipn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ipn = ipn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getIpn() {
        return ipn;
    }

    public void setIpn(String ipn) {
        this.ipn = ipn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ipn='" + ipn + '\'' +
                '}';
    }
}
