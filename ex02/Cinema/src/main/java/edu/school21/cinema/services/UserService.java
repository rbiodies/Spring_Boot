package edu.school21.cinema.services;

import edu.school21.cinema.models.*;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private EmailService emailService;

    @Value("${server.address}")
    private String serverAddress;

    @Value("${server.port}")
    private int serverPort;

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
        user.setVerification(EVerifications.NOT_CONFIRMED);

        userRepository.save(user);

        ConfirmationToken confirmationToken = new ConfirmationToken(user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";

        content = content.replace("[[name]]", user.getFirstName());
        String verifyURL = "http://"+serverAddress+":"+serverPort+"/confirm/"+confirmationToken.getConfirmationToken();

        content = content.replace("[[URL]]", verifyURL);

        emailService.sendMailWithAttachment(user.getEmail(), "Please verify your registration", content, null);
        return true;
    }

    public void verifyUser(String token) throws Exception {
        ConfirmationToken confirmationToken = confirmationTokenService.findByConfirmationToken(token);
        if (confirmationToken == null || !Objects.equals(token, confirmationToken.getConfirmationToken()) || confirmationToken.isExpired()) {
            throw new Exception("Token is not valid");
        }
        User user = userRepository.getOne(confirmationToken.getUser().getId());
        user.setVerification(EVerifications.CONFIRMED);
        userRepository.save(user);

        confirmationTokenService.removeToken(confirmationToken);
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
        if (user1.getVerification() == EVerifications.CONFIRMED) {
            user1.setEnabled(true);
        }
        return user1;
    }
}
