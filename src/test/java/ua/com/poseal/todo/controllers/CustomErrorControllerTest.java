package ua.com.poseal.todo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ua.com.poseal.todo.exceptions.AppError;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(controllers = CustomErrorController.class)
@ExtendWith(MockitoExtension.class)
class CustomErrorControllerTest {
    @Autowired
    MockMvc mockMvc;

//    @Test
//    @DisplayName("GET /error")
//    void handleError() throws Exception {
//
//        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/error"));
//        MockHttpServletResponse response = result.andReturn().getResponse();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        AppError appError = objectMapper.readValue(response.getContentAsString(), AppError.class);
//
//        assertEquals("Wrong URL", appError.getMessage());
//        assertEquals(400, appError.getStatusCode());
//
//    }
}