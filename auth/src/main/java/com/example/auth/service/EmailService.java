package com.example.auth.service;

import com.example.auth.model.dtos.auth.EmailDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    @Value(value = "${spring.mail.username}")
    private String username;

    public void postEmail(EmailDto emailDto) throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(username, "noreply@gmail.com");
        helper.setTo(emailDto.getEmail());
        helper.setSubject(emailDto.getSubject());
        helper.setText(getContentFromTemplate(emailDto.getCode(), emailDto.getSubject(), emailDto.getMessage()), true);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> javaMailSender.send(mimeMessage));
    }

    private String getContentFromTemplate(String code, String subject, String message) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("email-templates/activate_account.html");
        return classPathResource.getContentAsString(StandardCharsets.UTF_8).replace("CODE", code).replace("SUBJECT", subject).replace("MESSAGE", message);
    }

}