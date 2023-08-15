package ua.com.poseal.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.poseal.todo.domain.User;
import ua.com.poseal.todo.exceptions.ResponseNotValidDataException;
import ua.com.poseal.todo.exceptions.UserNotFoundException;
import ua.com.poseal.todo.services.UserService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        return users.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User userFromDB = null;
        URI uri = null;
//        try {
            userFromDB = service.createUser(user);
            uri = URI.create("/users/" + userFromDB.getId());
//        } catch (ResponseNotValidDataException e) {
//            throw new ResponseNotValidDataException(e.getMessage());
//        }
        return ResponseEntity.created(uri).body(userFromDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
//        User updatedUser;
//        try {
//            updatedUser = service.updateUser(id, user);
//        } catch (UserNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedUser);
        return ResponseEntity.ok(service.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
