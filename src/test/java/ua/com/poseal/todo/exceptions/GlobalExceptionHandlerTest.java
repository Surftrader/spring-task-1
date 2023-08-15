package ua.com.poseal.todo.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ua.com.poseal.todo.AppExceptionHandler;
import ua.com.poseal.todo.controllers.CustomErrorController;
import ua.com.poseal.todo.controllers.UserController;

import static org.junit.jupiter.api.Assertions.*;

//@WebMvcTest(controllers = UserController.class)
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//@ExtendWith(AppExceptionHandler.class)
class GlobalExceptionHandlerTest {


//    @Autowired
//    MockMvc mockMvc;
//
//    @InjectMocks
//    UserController userController;
//
//    @Test
//    @ExtendWith(AppExceptionHandler.class)
//    void catchResourceNotFoundException() throws Exception {
//        long nonExistentId = 50L;
//        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/users/50"));
//        MockHttpServletResponse response = result.andReturn().getResponse();
//        System.out.println(response);
//        ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class, () -> {
//            userController.deleteUser(nonExistentId);
//        });
//
//        assertEquals("User with id " + nonExistentId + " not found", thrown.getMessage());
//    }
//
//    @Test
//    void catchWrongDataException() {
//    }
//
//    @Test
//    void catchMethodArgumentTypeMismatchException() {
//    }
//
//    @Test
//    void catchErrorURLException() {
//    }
//
//    @Test
//    void catchHttpRequestMethodNotSupportedException() {
//    }
}