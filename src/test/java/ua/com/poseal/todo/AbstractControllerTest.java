package ua.com.poseal.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.poseal.todo.domain.User;
import ua.com.poseal.todo.repositories.UserRepository;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public abstract class AbstractControllerTest {

    @Mock
    public UserRepository repository;
    public User invalidUser;
    public User validUser;
    public List<User> users;

    @BeforeEach
    void setup() {
        invalidUser = new User("John", "Doe", "1234567890");
        validUser = new User("John", "Doe", "2732612837");
        users = List.of(
                new User(1L, "John", "Doe", "2732612837"),
                new User(2L, "Tom", "Jerry", "2732612837"),
                new User(3L, "Jack", "Nicholson", "2732612837")
        );
    }
}
