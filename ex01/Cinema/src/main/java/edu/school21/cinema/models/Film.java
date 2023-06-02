package edu.school21.cinema.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String yearOfRelease;
    private String ageRestrictions;
    private String description;
    private String posterUrl;

    public Film(String name, String yearOfRelease, String ageRestrictions, String description) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.ageRestrictions = ageRestrictions;
        this.description = description;
    }
}
