package edu.school21.cinema.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private String numberOfSeats;

    public Hall(String serialNumber, String numberOfSeats) {
        this.serialNumber = serialNumber;
        this.numberOfSeats = numberOfSeats;
    }
}
