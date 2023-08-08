package ua.com.poseal.todo.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("User with id " + id + " not found");
    }
}
