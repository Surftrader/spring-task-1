package ua.com.poseal.todo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.poseal.todo.exceptions.AppError;
import ua.com.poseal.todo.exceptions.ErrorURLException;

@RestController
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

    @GetMapping
    public ResponseEntity<AppError> handleError() {
        throw new ErrorURLException("Wrong URL");
    }
}
