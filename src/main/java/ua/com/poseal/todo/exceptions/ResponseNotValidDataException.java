package ua.com.poseal.todo.exceptions;

public class ResponseNotValidDataException extends RuntimeException {
    public ResponseNotValidDataException(String message) {
        super(message);
    }
}
