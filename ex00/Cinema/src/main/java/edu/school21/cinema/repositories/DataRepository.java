package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Long> {

    List<Data> findAllByUserId(Long userId);
}
