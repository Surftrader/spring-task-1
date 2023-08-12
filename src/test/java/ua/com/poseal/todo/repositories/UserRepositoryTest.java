package ua.com.poseal.todo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import ua.com.poseal.todo.domain.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @Sql("classpath:/sql/data.sql")
    void shouldGetAllUsers() {
        configureRepository();
        List<User> users = userRepository.findAll();
        assertEquals(3, users.size());
    }

    private CommandLineRunner configureRepository() {
        List<User> users = List.of(
                new User( "John",  "Doe", "2732612837"),
                new User("Tom",  "Jerry", "2732612837"),
                new User("Jack",  "Nicholson", "2732612837")
        );
        return args -> {
            userRepository.saveAll(users);
        };
    }
}