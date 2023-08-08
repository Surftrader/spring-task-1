package ua.com.poseal.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.poseal.todo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
