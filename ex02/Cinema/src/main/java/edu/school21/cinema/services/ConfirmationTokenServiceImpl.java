package edu.school21.cinema.services;

import edu.school21.cinema.models.ConfirmationToken;
import edu.school21.cinema.repositories.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    ConfirmationTokenRepository repo;

    @Autowired
    public ConfirmationTokenServiceImpl(ConfirmationTokenRepository repo) {
        this.repo = repo;
    }

    @Override
    public void saveConfirmationToken(ConfirmationToken token) {
        repo.save(token);
    }

    @Override
    public ConfirmationToken findByConfirmationToken(String confirmationToken) {
        return repo.findByConfirmationToken(confirmationToken);
    }

    @Override
    public void removeToken(ConfirmationToken token) {
        repo.delete(token);
    }
}
