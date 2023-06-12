package edu.school21.cinema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendMailWithAttachment(String toAddress, String subject, String text, String pathToAttachment) {

        MimeMessage message = emailSender.createMimeMessage();

        try {

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toAddress);
            helper.setSubject(subject);
            helper.setText(text, true);

            if (pathToAttachment != null) {
                FileSystemResource file
                        = new FileSystemResource(new File(pathToAttachment));
                helper.addAttachment("Invoice", file);
            }

            emailSender.send(message);

        } catch (MessagingException ignored) {
        }

    }
}
