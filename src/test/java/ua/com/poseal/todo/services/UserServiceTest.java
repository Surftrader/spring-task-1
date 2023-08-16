package ua.com.poseal.todo.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.com.poseal.todo.AbstractTest;
import ua.com.poseal.todo.domain.User;
import ua.com.poseal.todo.repositories.UserRepository;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest extends AbstractTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @Mock
    Validator validator;

    @Test
    void shouldReturnUserById() {
        long id = 1L;
        List<User> users = getUsers();
        when(userRepository.findById(id)).thenReturn(Optional.ofNullable(users.get(0)));

        User userById = userService.findById(id);

        assertNotNull(userById);
        assertEquals(users.get(0), userById);

    }

    @Test
    void shouldReturnAllUsers() {
        List<User> users = getUsers();
        when(userRepository.findAll()).thenReturn(users);

        List<User> usersList = userService.findAll();

        assertNotNull(usersList);
        assertEquals(users.size(), usersList.size());
    }

    @Test
    void shouldSaveValidUserToDB() {
        List<User> users = new ArrayList<>(getUsers());
        User validUser = getValidUser();
        validUser.setId((long) users.size());

        when(validator.validate(validUser)).thenReturn(Set.of());
        when(userRepository.save(validUser)).thenReturn(validUser);
        users.add(validUser);

        User user = userService.createUser(validUser);

        assertNotNull(user);
        assertEquals(4, users.size());
        assertEquals(users.get(users.size() - 1), user);

    }
}
