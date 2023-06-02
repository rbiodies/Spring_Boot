package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User u set u.avatarUrl = ?1 where u.id = ?2")
    void updateUser(String avatarUrl, Long userId);
}
