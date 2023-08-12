package ua.com.poseal.todo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ua.com.poseal.todo.domain.User;
import ua.com.poseal.todo.services.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = UserController.class)
//@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
//
//    ObjectMapper objectMapper;
//    @Autowired
//    MockMvc mockMvc;
//    @Mock
//    UserService userService;
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
}