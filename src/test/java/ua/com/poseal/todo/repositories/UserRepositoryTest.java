package ua.com.poseal.todo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ua.com.poseal.todo.domain.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void shouldGetAllUsers() {
        int expected = 3;
        List<User> users = userRepository.findAll();

        assertNotNull(users);
        assertEquals(expected, users.size());
    }
}