package ua.com.poseal.todo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import ua.com.poseal.todo.domain.User;
import ua.com.poseal.todo.exceptions.AppError;
import ua.com.poseal.todo.exceptions.ErrorURLException;
import ua.com.poseal.todo.exceptions.UserNotFoundException;
import ua.com.poseal.todo.services.UserService;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {
    private static final String ENDPOINT_PATH = "/users";
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    void shouldReturn200OKAfterFindUsers() throws Exception {
        List<User> users = getUsers();

        Mockito.when(userService.findAll()).thenReturn(users);
        String requestBody = objectMapper.writeValueAsString(users);

        mockMvc.perform(get(ENDPOINT_PATH)
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].firstName", is("John")))
                .andExpect(jsonPath("$[0].lastName", is("Doe")))
                .andExpect(jsonPath("$[0].ipn", is("2732612837")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].firstName", is("Tom")))
                .andExpect(jsonPath("$[1].lastName", is("Jerry")))
                .andExpect(jsonPath("$[1].ipn", is("2732612837")))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].firstName", is("Jack")))
                .andExpect(jsonPath("$[2].lastName", is("Nicholson")))
                .andExpect(jsonPath("$[2].ipn", is("2732612837")))
                .andDo(print());
    }

//    @Test
//    void shouldReturn201AfterCreate() throws Exception {
//        User newUser = getValidUser();
////        newUser.setId(4L);
//        Mockito.when(userService.createUser(newUser)).thenReturn(newUser);
//
//        String requestBody = objectMapper.writeValueAsString(newUser);
//        mockMvc.perform(post(ENDPOINT_PATH)
//                        .contentType("application/json")
//                        .content(requestBody))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id", is(4)))
//                .andExpect(jsonPath("$.firstName", is("John")))
//                .andExpect(jsonPath("$.lastName", is("Doe")))
//                .andExpect(jsonPath("$.ipn", is("2732612837")))
//                .andDo(print());
//
//        Mockito.verify(userService).createUser(newUser);
//    }

    @Test
    void shouldReturn200OKAfterFindUser() throws Exception {
        long userId = 1L;
        String requestURI = ENDPOINT_PATH + "/" + userId;

        User user = getUsers().get(0);
        Mockito.when(userService.findById(userId)).thenReturn(user);

        String requestBody = objectMapper.writeValueAsString(user);

        mockMvc.perform(get(requestURI)
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andDo(print());
    }

    @Test
    void shouldReturn404NotFoundIfGoToWrongEndpoint() throws Exception {
        AppError appError = new AppError(
                HttpStatus.NOT_FOUND.value(),
                new ErrorURLException("Wrong URL").getMessage());

        String answer = objectMapper.writeValueAsString(appError);
        String wrongEndpoint = ENDPOINT_PATH.substring(0, 3);

        mockMvc.perform(get(wrongEndpoint)
                        .contentType("application/json")
                        .content(answer))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void shouldReturn404NotFoundAfterFindUser() throws Exception {
        long nonExistentId = 123L;
        String requestURI = ENDPOINT_PATH + "/" + nonExistentId;

        Mockito.when(userService.findById(nonExistentId)).thenThrow(UserNotFoundException.class); // ? "User with id " + nonExistentId + " not found"

        mockMvc.perform(get(requestURI))
                .andExpect(status().isNotFound())
                .andDo(print())
                .andExpect(jsonPath("$.statusCode", equalTo(HttpStatus.NOT_FOUND.value())));
//                .andExpect(jsonPath("$.message", contains("User with id " + nonExistentId + " not found")));
    }

    @Test
    void shouldReturn404BadRequestAfterCreateInvalidUser() throws Exception {
        User invalidUser = getInvalidUser();
        String requestBody = objectMapper.writeValueAsString(invalidUser);

        mockMvc.perform(post(ENDPOINT_PATH)
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andExpect(jsonPath("$.statusCode", equalTo(HttpStatus.BAD_REQUEST.value())));
    }

    @Test
    void shouldReturn204NoContent() throws Exception {
        Mockito.when(userService.findAll()).thenReturn(List.of());

        mockMvc.perform(get(ENDPOINT_PATH))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

//    @Test
//    void shouldReturn404NotFoundAfterUpdate() throws Exception {
//        long nonExistentId = 123L;
//        String requestURI = ENDPOINT_PATH + "/" + nonExistentId;
//        User user = getValidUser();
//        user.setId(nonExistentId);
//
//        Mockito.when(userService.updateUser(nonExistentId, user)).thenThrow(UserNotFoundException.class);
////        Mockito.when(userService.updateUser(nonExistentId, user)).thenThrow(() -> new UserNotFoundException(nonExistentId));
//
//        String requestBody = objectMapper.writeValueAsString(user);
//
//        mockMvc.perform(put(requestURI)
//                        .contentType("application/json")
//                        .content(requestBody))
//                .andExpect(status().isNotFound())
//                .andDo(print())
//                .andExpect(jsonPath("$.statusCode", equalTo(HttpStatus.NOT_FOUND.value())));
//    }

//    @Test
//    void shouldReturn200AfterUpdate() throws Exception {
//        long userId = 2L;
//        String requestURI = ENDPOINT_PATH + "/" + userId;
//        User user = getValidUser();
//        user.setId(userId);
//
//        Mockito.when(userService.updateUser(userId, user)).thenReturn(user);
//        String requestBody = objectMapper.writeValueAsString(user);
//        System.out.println("requestBody -> " + requestBody);
//        mockMvc.perform(put(requestURI)
//                        .contentType("application/json")
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(2)))
//                .andExpect(jsonPath("$.firstName", is("John")))
//                .andExpect(jsonPath("$.lastName", is("Doe")))
//                .andExpect(jsonPath("$.ipn", is("2732612837")))
//                .andDo(print());
//    }

    @Test
    void shouldReturn404NotFoundAfterDelete() throws Exception {
        long nonExistentId = 123L;
        String requestURI = ENDPOINT_PATH + "/" + nonExistentId;

        Mockito.doThrow(UserNotFoundException.class).when(userService).deleteUser(nonExistentId);

        mockMvc.perform(delete(requestURI))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void shouldReturn200OKAfterDelete() throws Exception {
        long userId = 1L;
        String requestURI = ENDPOINT_PATH + "/" + userId;

        Mockito.doNothing().when(userService).deleteUser(userId);

        mockMvc.perform(delete(requestURI))
                .andExpect(status().isNoContent())
                .andDo(print());
    }
//    @InjectMocks
//    UserController userController;
//    List<User> users;
//
//    User validUser;
//
//    @BeforeEach
//    void setup() {
//        users = List.of(
//                new User(1L, "John", "Doe", "2732612837"),
//                new User(2L, "Tom", "Jerry", "2732612837"),
//                new User(3L, "Jack", "Nicholson", "2732612837")
//        );
//        objectMapper = new ObjectMapper();
//        validUser = users.get(0);
//    }
//
//    @Test
//    void findAll_ReturnsValidUsers() {
//        // given
//        when(userService.findAll()).thenReturn(users);
//
//        // when
//        var userList = userController.findAll();
//
//        // then
//        assertNotNull(userList);
//        assertEquals(users.size(), userList.size());
//        for (int i = 0; i < userList.size(); i++) {
//            assertEquals(users.get(i).getId(), userList.get(i).getId());
//            assertEquals(users.get(i).getFirstName(), userList.get(i).getFirstName());
//            assertEquals(users.get(i).getLastName(), userList.get(i).getLastName());
//            assertEquals(users.get(i).getIpn(), userList.get(i).getIpn());
//        }
//        verify(userService).findAll();
//    }
//
//    @Test
//    void getUser_ReturnUserById() throws Exception {
//        // given
//        long id = 1L;
//        when(userService.findById(id)).thenReturn(users.get(0));
//
//        // when
////        var user = userController.getUser(id);
//        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/users", id)
//                .content(objectMapper.writeValueAsString(validUser)));
//
//        response.andExpect(MockMvcResultMatchers.status().isOk());
//
////        MockHttpServletResponse response = result.andReturn().getResponse();
////        System.out.println(response.getContentAsString());
////        User fromDB = users.get(0);
////
////        // then
////        assertNotNull(user);
////        assertEquals(user.getId(), fromDB.getId());
////        assertEquals(user.getFirstName(), fromDB.getFirstName());
////        assertEquals(user.getLastName(), fromDB.getLastName());
////        assertEquals(user.getIpn(), fromDB.getIpn());
//        verify(userService).findById(id);
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