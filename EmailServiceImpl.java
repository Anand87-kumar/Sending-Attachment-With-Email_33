package com.anand.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.anand.entity.Email;
import com.anand.repository.EmailRepository;
import com.anand.service.EmailService;

import jakarta.mail.internet.MimeMessage;

import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmailRepository emailRepository;

    @Override
    @Transactional
    public void sendEmailWithAttachment(String to, String subject, String text, MultipartFile attachment) throws Exception {
        // Sending email logic
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        if (attachment != null && !attachment.isEmpty()) {
            helper.addAttachment(Objects.requireNonNull(attachment.getOriginalFilename()), attachment);
        }

        javaMailSender.send(message);

        // Saving email details to the database
        Email email = new Email();
        email.setToEmail(to);
        email.setSubject(subject);
        email.setText(text);

        emailRepository.save(email);
    }
}

