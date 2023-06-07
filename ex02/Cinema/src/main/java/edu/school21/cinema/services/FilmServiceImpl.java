package edu.school21.cinema.services;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.repositories.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

    FilmsRepository repo;

    @Autowired
    public FilmServiceImpl(FilmsRepository repo) {
        this.repo = repo;
    }

    @Override
    public Film findById(Long filmId) {
        return repo.findById(filmId).orElse(null);
    }

    @Override
    public void save(Film film) {
        repo.save(film);
    }

    public void update(Film film) {
        repo.updateFilm(film.getName(), film.getYearOfRelease(), film.getAgeRestrictions(), film.getDescription(), film.getId());
    }

    @Override
    public List<Film> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Film> search(String keyword) {
        return repo.findAllByNameOrYearOfReleaseOrAgeRestrictionsOrDescriptionLike(keyword, keyword, keyword, keyword);
    }

}
