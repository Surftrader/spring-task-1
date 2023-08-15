package ua.com.poseal.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.poseal.todo.domain.User;
import ua.com.poseal.todo.exceptions.UserNotFoundException;
import ua.com.poseal.todo.exceptions.ResponseNotContentException;
import ua.com.poseal.todo.exceptions.ResponseNotValidDataException;
import ua.com.poseal.todo.repositories.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    //    private static final String USERS_CSV = "users_information.csv";
    private final UserRepository repository;
    private final Validator validator;

    @Autowired
    public UserService(UserRepository repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public List<User> findAll() {
        List<User> users = repository.findAll();
        if (users.isEmpty()) {
            throw new ResponseNotContentException("Empty data");
        }
        return users;
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new UserNotFoundException(id));
    }

    public User createUser(User user) {
        validateUser(user);
        return repository.save(user);
    }

    public User updateUser(Long id, User user) {
        validateUser(user);
        user.setId(id);
//        User userFromDB = repository.findById(id).orElseThrow(
//                () -> new UserNotFoundException(id));
//
//        userFromDB.setFirstName(user.getFirstName());
//        userFromDB.setLastName(user.getLastName());
//        userFromDB.setIpn(user.getIpn());
//
//        return repository.save(user);

        return repository.findById(id)
                .map(u -> {
                    u.setFirstName(user.getFirstName());
                    u.setLastName(user.getLastName());
                    u.setIpn(user.getIpn());
                    return repository.save(u);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void deleteUser(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
        throw new UserNotFoundException(id);
    }

    private void validateUser(User user) {
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        if (!validate.isEmpty()) {
            throw new ResponseNotValidDataException(getErrors(validate));
        }
    }

    private String getErrors(Set<ConstraintViolation<User>> validate) {
        return validate.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
    }

//    @PostConstruct
//    private void initUsersFromCSV() {
//        List<User> usersList = new ArrayList<>();
//        try (InputStream resource = new ClassPathResource(USERS_CSV).getInputStream();
//             BufferedReader reader = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] usersString = line.split(";");
//                usersList.add(
//                        new User(Long.parseLong(
//                                usersString[0].trim()),
//                                usersString[1].trim(),
//                                usersString[2].trim(),
//                                usersString[3].trim())
//                );
//            }
//        } catch (IOException ex) {
//            logger.error("Error reading file {}", USERS_CSV, ex);
//        }
//        repository.saveAll(usersList);
//    }
}
