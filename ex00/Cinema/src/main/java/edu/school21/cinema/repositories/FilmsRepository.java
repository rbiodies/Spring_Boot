package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FilmsRepository extends JpaRepository<Film, Long> {

    @Override
    Optional<Film> findById(Long aLong);

    List<Film> findAllByNameOrYearOfReleaseOrAgeRestrictionsOrDescriptionLike(String keyword, String keyword2, String keyword3, String keyword4);

    @Modifying
    @Query("update Film f set f.name = ?1, f.yearOfRelease = ?2, f.ageRestrictions = ?3, f.description = ?4 where f.id = ?5")
    void updateFilm(String filmName, String filmYearOfRelease, String filmAgeRestrictionsLong, String filmDescription, Long hallId);
}
