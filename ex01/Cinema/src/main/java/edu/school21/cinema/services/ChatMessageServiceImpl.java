package edu.school21.cinema.services;

import edu.school21.cinema.models.ChatMessage;
import edu.school21.cinema.repositories.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class ChatMessageServiceImpl implements ChatMessageService {

    ChatMessageRepository repo;

    @Autowired
    public ChatMessageServiceImpl(ChatMessageRepository repo) {
        this.repo = repo;
    }

    @Override
    public ChatMessage findById(Long chatMessageId) {
        return repo.findById(chatMessageId).get();
    }

    @Override
    public void save(ChatMessage chatMessage) {
        repo.save(chatMessage);
    }

    @Override
    public void update(ChatMessage chatMessage) {
    }

    @Override
    public List<ChatMessage> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<ChatMessage> search(String keyword) {
        return null;
    }

    @Override
    public List<ChatMessage> findTopByFilmIdOrderByTimestampDesc(Long filmId, int count) {
        List<ChatMessage> chatMessages = repo.findByIdOrderByIdDesc(filmId);
        return chatMessages.subList(Math.max(chatMessages.size() - count, 0), chatMessages.size());
    }
}
