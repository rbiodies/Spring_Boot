package edu.school21.cinema.services;

public interface EmailService {

    void sendMailWithAttachment(String toAddress, String subject, String message, String attachment);
}
