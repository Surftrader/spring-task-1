package ua.com.poseal.todo.domain;

import org.springframework.stereotype.Component;
import ua.com.poseal.todo.util.IPNCheck;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @IPNCheck
    @NotNull
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        return id.equals(user.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return id.hashCode();
//    }

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
