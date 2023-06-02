package edu.school21.cinema.controllers;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class SecurityControllerAdvice {
    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public String handleAuthException(AuthenticationCredentialsNotFoundException e, HttpServletResponse response) throws IOException {
        response.sendRedirect("/signIn");
        return null;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException e, HttpServletResponse response) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            response.sendRedirect("/signIn");
        } else {
            response.sendRedirect("/profile");
        }
        return null;
    }
}
