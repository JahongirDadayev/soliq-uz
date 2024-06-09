package com.example.auth.controller;

import com.example.auth.model.dtos.auth.LoginDto;
import com.example.auth.model.dtos.auth.RegisterDto;
import com.example.auth.model.dtos.auth.VerificationDto;
import com.example.auth.model.dtos.base.Header;
import com.example.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.auth.commons.constants.RestConstants.AUTH;
import static com.example.auth.commons.constants.RestConstants.BASE_URL;

@RestController
@RequestMapping(value = BASE_URL + AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(path = "/register")
    public Header<?> register(@RequestBody @Valid RegisterDto registerDto) {
        authService.register(registerDto);
        return Header.ok();
    }

    @PostMapping(path = "/verification")
    public Header<?> verification(@RequestBody @Valid VerificationDto verificationDto) {
        return Header.ok(authService.verification(verificationDto));
    }

    @PostMapping(path = "/login")
    public Header<?> login(@RequestBody @Valid LoginDto loginDto) {
        return Header.ok(authService.login(loginDto));
    }

}
