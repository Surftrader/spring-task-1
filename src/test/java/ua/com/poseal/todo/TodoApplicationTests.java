package ua.com.poseal.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.poseal.todo.domain.User;
import ua.com.poseal.todo.repositories.UserRepository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ua.com.poseal.todo.TodoApplication.logger;

//@ExtendWith(SpringRunner.class)
@SpringBootTest
class TodoApplicationTests {
	private static final String USERS_CSV = "users_information.csv";

	@Autowired
	UserRepository repository;
	@Test
	void contextLoads() throws Exception {
	}

	@BeforeEach
	void setup() {
//		initUsersFromCSV();
	}
//	@PostConstruct
//	private void initUsersFromCSV() {
//		List<User> usersList = new ArrayList<>();
//		try (InputStream resource = new ClassPathResource(USERS_CSV).getInputStream();
//			 BufferedReader reader = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))) {
//			String line;
//			while ((line = reader.readLine()) != null) {
//				String[] usersString = line.split(";");
//				usersList.add(
//						new User(Long.parseLong(
//								usersString[0].trim()),
//								usersString[1].trim(),
//								usersString[2].trim(),
//								usersString[3].trim())
//				);
//			}
//		} catch (IOException ex) {
//			logger.error("Error reading file {}", USERS_CSV, ex);
//		}
//		repository.saveAll(usersList);
//	}
}
