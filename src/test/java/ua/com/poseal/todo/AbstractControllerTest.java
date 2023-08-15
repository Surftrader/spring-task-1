package ua.com.poseal.todo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import ua.com.poseal.todo.domain.User;
import ua.com.poseal.todo.repositories.UserRepository;

import java.util.List;

//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc(addFilters = false)
//@Import(UserBuilder.class)
public abstract class AbstractControllerTest {

//    public UserRepository repository;
//    public static User invalidUser;
//    public static User validUser;
//
////    @Autowired
////    public List<User> users;
//
//    @BeforeAll
//    static void setUpBeforeClass() throws Exception {
//        validUser = new User("John", "Doe", "2732612837");
//        invalidUser = new User("John", "Doe", "1234567890");
//    }

//    @BeforeEach
//    void setup() {
//        invalidUser = new User("John", "Doe", "1234567890");
//        validUser = new User("John", "Doe", "2732612837");
//        users = List.of(
//                new User(1L, "John", "Doe", "2732612837"),
//                new User(2L, "Tom", "Jerry", "2732612837"),
//                new User(3L, "Jack", "Nicholson", "2732612837")
//        );
////        users = repository.findAll();
//    }
}
