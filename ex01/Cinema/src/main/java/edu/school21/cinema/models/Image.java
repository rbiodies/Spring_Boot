package edu.school21.cinema.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String fileName;
    private String size;
    private String mime;
    private String url;

    public Image(User user, String fileName, String size, String mime, String url) {
        this.user = user;
        this.fileName = fileName;
        this.size = size;
        this.mime = mime;
        this.url = url;
    }
}
