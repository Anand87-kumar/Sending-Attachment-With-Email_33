package com.anand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anand.service.EmailService;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmailWithAttachment(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("text") String text,
            @RequestParam("attachment") MultipartFile attachment) {

        try {
            emailService.sendEmailWithAttachment(to, subject, text, attachment);
            return ResponseEntity.ok("Email sent and saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send email and save: " + e.getMessage());
        }
    }
}

