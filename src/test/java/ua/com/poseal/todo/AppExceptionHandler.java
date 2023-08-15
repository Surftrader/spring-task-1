package ua.com.poseal.todo;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.springframework.http.HttpStatus;
import ua.com.poseal.todo.exceptions.AppError;
import ua.com.poseal.todo.exceptions.ErrorURLException;

public class AppExceptionHandler implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
//        if (throwable instanceof ErrorURLException) {
//            throw new AppError(HttpStatus.BAD_REQUEST.value(), throwable.getMessage());
//        }
    }
}
