package edu.school21.cinema.services;

import edu.school21.cinema.models.Data;
import edu.school21.cinema.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    DataRepository repo;

    @Autowired
    public DataServiceImpl(DataRepository repo) {
        this.repo = repo;
    }

    @Override
    public Data findById(Long dataId) {
        return repo.findById(dataId).orElse(null);
    }

    @Override
    public void save(Data data) {
        repo.save(data);
    }

    @Override
    public void update(Data data) {
    }

    @Override
    public List<Data> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Data> search(String keyword) {
        return null;
    }

    @Override
    public List<Data> findAllByUserId(Long userId) {
        return repo.findAllByUserId(userId);
    }

}
