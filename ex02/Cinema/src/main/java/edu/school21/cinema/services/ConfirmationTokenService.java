package edu.school21.cinema.services;

import edu.school21.cinema.models.ConfirmationToken;

public interface ConfirmationTokenService {

    void saveConfirmationToken(final ConfirmationToken token);

    ConfirmationToken findByConfirmationToken(String confirmationToken);

    void removeToken(final ConfirmationToken token);
}
