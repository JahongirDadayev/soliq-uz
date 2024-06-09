package com.example.auth.model.dtos.auth;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VerificationDto {
    @Email(message = "Email isn't correct!")
    private String username;

    private String code;

}
