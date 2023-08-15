package ua.com.poseal.todo.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.poseal.todo.domain.User;
import ua.com.poseal.todo.repositories.UserRepository;

import javax.validation.Validator;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
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
        // add validUser to users
        users.add(validUser); //???

        User user = userService.createUser(validUser);

        assertNotNull(user);
        assertEquals(4, users.size());
        assertEquals(users.get(users.size() - 1), user);

    }

//    @Test
//    void shouldDeleteUserById() {
//        List<User> users = getUsers();
//        long id = 1L;
//        doAnswer(
//                invocation -> {
//                    Object[] arguments = invocation.getArguments();
//                    Object mock = invocation.getMock();
//                    return "";
//                }
//        )
//        .when(userRepository.deleteById(id));
//
//    }

//
//    @Test
//    void findAll_ReturnsValidUsers() {
//        // given
//        when(repository.findAll()).thenReturn(users);
//
//        // when
//        var userList = userService.findAll();
//
//        // then
//        assertNotNull(userList);
//        assertEquals(users, userList);
//        verify(repository).findAll();
//    }
//
//    @Test
//    void findAll_ReturnsEmptyList() {
//        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
//                () -> userService.findAll());
//
//        assertEquals(HttpStatus.NO_CONTENT + " " + "\"Empty data\"", exception.getMessage());
//        assertEquals(HttpStatus.NO_CONTENT, exception.getStatus());
//        verify(repository).findAll();
//    }

    private List<User> getUsers() {
        return List.of(
                new User(1L, "John", "Doe", "2732612837"),
                new User(2L, "Tom", "Jerry", "2732612837"),
                new User(3L, "Jack", "Nicholson", "2732612837")
        );
    }

    private User getValidUser() {
        return new User("John", "Doe", "2732612837");
    }
    private User getInvalidUser() {
        return new User("John", "Doe", "2732612830");
    }
}