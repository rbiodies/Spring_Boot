package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HallsRepository extends JpaRepository<Hall, Long> {

    List<Hall> findAllBySerialNumberOrNumberOfSeatsLike(String keyword, String keyword2);

    @Modifying
    @Query("update Hall h set h.serialNumber = ?1, h.numberOfSeats = ?2 where h.id = ?3")
    void updateHall(String hallSerialNumber, String hallNumberOfSeats, Long hallId);
}
