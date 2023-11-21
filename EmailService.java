package com.anand.service;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    void sendEmailWithAttachment(String to, String subject, String text, MultipartFile attachment) throws Exception;
}

