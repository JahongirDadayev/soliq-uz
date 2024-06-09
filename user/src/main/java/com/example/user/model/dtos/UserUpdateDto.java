package com.example.user.model.dtos;

import com.example.user.model.dtos.base.BaseUpdateDto;
import com.example.user.model.enums.UserStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDto implements BaseUpdateDto {
    @NotNull
    private String fullName;

    @NotNull
    private String password;

    @NotNull
    private UserStatus status;

    private String validationCode;

}
