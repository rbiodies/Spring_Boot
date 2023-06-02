package edu.school21.cinema.services;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class ImageServiceImpl implements ImageService {

    ImageRepository repo;

    @Autowired
    public ImageServiceImpl(ImageRepository repo) {
        this.repo = repo;
    }

    @Override
    public Image findById(Long imageId) {
        return null;
    }

    @Override
    public void save(Image image) {
        repo.save(image);
    }

    public void update(Image image) {
    }

    @Override
    public List<Image> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Image> search(String keyword) {
        return null;
    }

    @Override
    public List<Image> findAllByUserId(Long userId) {
        return repo.findAllByUserId(userId);
    }
}
