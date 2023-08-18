package ua.com.poseal.todo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.poseal.todo.exceptions.AppError;
import ua.com.poseal.todo.exceptions.ErrorURLException;

import static ua.com.poseal.todo.TodoApplication.logger;

@RestController
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

    @GetMapping
    public ResponseEntity<AppError> handleError() {
        logger.error("Wrong URL");
        throw new ErrorURLException("Wrong URL");
    }
}
