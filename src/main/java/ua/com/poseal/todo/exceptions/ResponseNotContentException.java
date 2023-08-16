package ua.com.poseal.todo.exceptions;

public class ResponseNotContentException extends RuntimeException {
    public ResponseNotContentException(String message) {
        super(message);
    }
}
