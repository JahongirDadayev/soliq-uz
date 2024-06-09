package com.example.user.model.dtos;

import com.example.user.model.dtos.base.BaseCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto implements BaseCreateDto {
    @NotNull
    private String fullName;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String validationCode;

}
