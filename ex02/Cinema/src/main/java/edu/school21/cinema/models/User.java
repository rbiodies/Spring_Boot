package edu.school21.cinema.models;

import edu.school21.cinema.validation.ValidPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{user.firstname.mandatory}")
    @Size(min=2, message = "{user.size}")
    private String firstName;

    @NotBlank(message = "{user.lastname.mandatory}")
    @Size(min=2, message = "{user.size}")
    private String lastName;

    @NotBlank(message = "{user.username.mandatory}")
    private String username;

    @Pattern(regexp = "^(\\+\\d{1,2})?\\(\\d{3}\\)\\d{7}$", message = "{user.phonenumber.mismatch}")
    private String phoneNumber;

    @NotBlank(message = "{user.email.mandatory}")
    @Email
    private String email;

    @ValidPassword(message = "{errors.incorrect.password}")
    private String password;

    @Transient
    private String passwordConfirm;

    @Enumerated(EnumType.STRING)
    private EVerifications verification;

    @Transient
    private boolean enabled;

    private String avatarUrl;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
