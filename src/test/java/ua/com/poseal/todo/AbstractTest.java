package ua.com.poseal.todo;

import ua.com.poseal.todo.domain.User;

import java.util.List;

public abstract class AbstractTest {

    public List<User> getUsers() {
        return List.of(
                new User(1L, "John", "Doe", "2732612837"),
                new User(2L, "Tom", "Jerry", "2732612837"),
                new User(3L, "Jack", "Nicholson", "2732612837")
        );
    }

    public User getValidUser() {
        return new User("John", "Doe", "2732612837");
    }

    public User getInvalidUser() {
        return new User("John", "Doe", "2732612830");
    }
}
