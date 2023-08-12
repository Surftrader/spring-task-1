package ua.com.poseal.todo.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import ua.com.poseal.todo.AbstractControllerTest;

import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class UserServiceTest extends AbstractControllerTest {

    @InjectMocks
    UserService userService;

    @Mock
    Validator validator;

    @Test
    void findAll_ReturnsValidUsers() {
        // given
        when(repository.findAll()).thenReturn(users);

        // when
        var userList = userService.findAll();

        // then
        assertNotNull(userList);
        assertEquals(users, userList);
        verify(repository).findAll();
    }

    @Test
    void findAll_ReturnsEmptyList() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> userService.findAll());

        assertEquals(HttpStatus.NO_CONTENT + " " + "\"Empty data\"", exception.getMessage());
        assertEquals(HttpStatus.NO_CONTENT, exception.getStatus());
        verify(repository).findAll();
    }
}