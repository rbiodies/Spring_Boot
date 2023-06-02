package edu.school21.cinema.repositories;

import edu.school21.cinema.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    @Query("SELECT c FROM ChatMessage c WHERE c.film.id = ?1 ORDER BY c.id DESC")
    List<ChatMessage> findByIdOrderByIdDesc(Long id);
}
