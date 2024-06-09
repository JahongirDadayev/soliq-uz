package com.example.auth.model.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    @NotNull
    private String fullName;

    @NotNull
    @Email(message = "Email isn't correct!")
    private String username;

    @NotNull
    private String password;
}
