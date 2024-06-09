package com.example.auth.service;

import com.example.auth.commons.clients.UserClient;
import com.example.auth.commons.exception.GeneralApiException;
import com.example.auth.commons.utils.GenerationCode;
import com.example.auth.model.dtos.auth.EmailDto;
import com.example.auth.model.dtos.auth.LoginDto;
import com.example.auth.model.dtos.auth.RegisterDto;
import com.example.auth.model.dtos.auth.TokenDto;
import com.example.auth.model.dtos.auth.VerificationDto;
import com.example.auth.model.dtos.user.User;
import com.example.auth.model.dtos.user.UserCreateDto;
import com.example.auth.model.dtos.user.UserUpdateDto;
import com.example.auth.model.enums.UserStatus;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthService {
    private final JwtService jwtService;

    private final UserClient userClient;

    private final EmailService emailService;

    private final PasswordEncoder passwordEncoder;

    private ExecutorService executorService;

    @PostConstruct
    public void init() {
        executorService = Executors.newSingleThreadExecutor();
    }

    @PreDestroy
    public void shutdown() {
        executorService.shutdown();
    }

    public void register(RegisterDto registerDto) {
        UserCreateDto userCreateDto = UserCreateDto.builder()
                .fullName(registerDto.getFullName())
                .username(registerDto.getUsername())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .validationCode(GenerationCode.generationCode())
                .build();
        User user = userClient.createUser(userCreateDto);
        executorService.submit(() -> {
                    try {
                        emailService.postEmail(
                                EmailDto.builder()
                                        .email(user.getUsername())
                                        .subject("Akkauntni Faollashtirish")
                                        .message("Sizni platformamizda ko'rganimizdan juda xursandmiz. Akkauntingizni quyidagi code bilan tasdiqlashingiz mumkin.")
                                        .code(user.getValidationCode())
                                        .build()
                        );
                    } catch (MessagingException | IOException e) {
                        log.error("Failed to send email", e);
                    }
                }
        );
    }

    public TokenDto verification(VerificationDto verificationDto) {
        User user = userClient.getByUsername(verificationDto.getUsername());
        if (user.getValidationCode().equals(verificationDto.getCode())) {
            user = userClient.updateUserForServices(
                    user.getId(),
                    UserUpdateDto.builder()
                            .fullName(user.getFullName())
                            .password(user.getPassword())
                            .status(UserStatus.ACTIVE)
                            .validationCode(null)
                            .build()
            );
            return new TokenDto(jwtService.generateInternalToken(user.getUsername()));
        } else {
            throw new GeneralApiException("Validation code incorrect!");
        }
    }

    public TokenDto login(LoginDto loginDto) {
        try {
            User user = userClient.checkUserCredentials(loginDto.getUsername(), loginDto.getPassword());
            log.info("User enter to the system {}", user.getUsername());
            return new TokenDto(jwtService.generateInternalToken(user.getUsername()));
        } catch (Exception e) {
            log.error("Exception occurred in getAnonymousToken method  {}", e.getMessage());
            e.printStackTrace();
            throw new GeneralApiException("Login or password incorrect!");
        }
    }

}
