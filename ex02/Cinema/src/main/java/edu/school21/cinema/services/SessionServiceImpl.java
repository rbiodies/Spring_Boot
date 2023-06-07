package edu.school21.cinema.services;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.repositories.SessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {

    SessionsRepository repo;

    @Autowired
    public SessionServiceImpl(SessionsRepository repo) {
        this.repo = repo;
    }

    @Override
    public Session findById(Long sessionId) {
        return repo.findById(sessionId).orElse(null);
    }

    @Override
    public void save(Session session) {
        repo.save(session);
    }

    public void update(Session session) {
        repo.updateSession(session.getDateTime(), session.getTicketCost(), session.getId());
    }

    @Override
    public List<Session> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Session> search(String keyword) {
        return repo.findAllByDateTimeOrTicketCostLike(keyword, keyword);
    }

    @Override
    public void deleteByHallId(Long id) {
        repo.deleteByHallId(id);
    }

    @Override
    public void deleteByFilmId(Long id) {
        repo.deleteByFilmId(id);
    }

    @Override
    public List<Session> findByFilmName(String filmName) {
        return repo.findAllByFilmNameLike(filmName + "%");
    }
}
