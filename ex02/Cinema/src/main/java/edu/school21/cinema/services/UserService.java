package edu.school21.cinema.services;

import edu.school21.cinema.models.Data;
import edu.school21.cinema.models.ERole;
import edu.school21.cinema.models.Role;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private static final String LOCALHOST_v6 = "0:0:0:0:0:0:0:1";
    private static final String LOCALHOST_v4 = "127.0.0.1";

    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private DataService dataService;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean saveUser(User user) {
        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB.isPresent()) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(ERole.ROLE_USER)));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public void update(String avatarUrl, Long userId) {
        userRepository.updateUser(avatarUrl, userId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(s);

        if (!user.isPresent()) {
            user = userRepository.findByUsername(s);
        }

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Not found!");
        }

        User user1 = user.get();
        dataService.save(new Data(user1, getClientDate(), getClientTime(), getClientIP()));
        return user1;
    }

    private String getClientDate() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy").withLocale(Locale.ENGLISH);
        return now.format(formatter);
    }

    private String getClientTime() {
        LocalTime now = LocalTime.now();
        return now.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    private String getClientIP() {
        String ip = request.getHeader("X-FORWARDED-FOR");

        if (ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals(LOCALHOST_v6)) {
            ip = LOCALHOST_v4;
        }
        return ip;
    }
}
