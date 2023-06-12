package edu.school21.cinema.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "confirmation_tokens")
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String confirmationToken;

    @CreationTimestamp
    private LocalDateTime createdDate;

    private LocalDateTime expiredDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Transient
    private boolean isExpired;

    public boolean isExpired() {
        return getExpiredDate().isBefore(LocalDateTime.now());
    }

    public ConfirmationToken(User user) {
        this.user = user;
        expiredDate = LocalDateTime.now().plusDays(1);
        confirmationToken = UUID.randomUUID().toString();
    }
}
