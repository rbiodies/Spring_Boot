package edu.school21.cinema.services;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.repositories.HallsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HallServiceImpl implements HallService {

    HallsRepository repo;

    @Autowired
    public HallServiceImpl(HallsRepository repo) {
        this.repo = repo;
    }

    @Override
    public Hall findById(Long hallId) {
        return repo.findById(hallId).orElse(null);
    }

    @Override
    public void save(Hall hall) {
        repo.save(hall);
    }

    public void update(Hall hall) {
        repo.updateHall(hall.getSerialNumber(), hall.getNumberOfSeats(), hall.getId());
    }

    @Override
    public List<Hall> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Hall> search(String keyword) {
        return repo.findAllBySerialNumberOrNumberOfSeatsLike(keyword, keyword);
    }

}
