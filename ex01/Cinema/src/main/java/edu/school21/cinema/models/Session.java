package edu.school21.cinema.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    private String dateTime;
    private String ticketCost;

    public Session(Hall hall, Film film, String dateTime, String ticketCost) {
        this.hall = hall;
        this.film = film;
        this.dateTime = dateTime;
        this.ticketCost = ticketCost;
    }
}
