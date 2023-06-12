package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionsRepository extends JpaRepository<Session, Long> {

    void deleteByHallId(Long id);

    void deleteByFilmId(Long id);

    List<Session> findAllByFilmNameLike(String name);

    List<Session> findAllByDateTimeOrTicketCostLike(String keyword, String keyword2);

    @Modifying
    @Query("update Session s set s.dateTime = ?1, s.ticketCost = ?2 where s.id = ?3")
    void updateSession(String sessionDateTime, String sessionTicketHost, Long hallId);
}
