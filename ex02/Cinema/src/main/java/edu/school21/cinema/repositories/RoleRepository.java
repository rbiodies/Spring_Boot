package edu.school21.cinema.repositories;

import edu.school21.cinema.models.ERole;
import edu.school21.cinema.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole role_user);
}
