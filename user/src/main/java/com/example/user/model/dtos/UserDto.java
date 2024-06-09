package com.example.user.model.dtos;

import com.example.user.model.dtos.base.BaseDTO;
import com.example.user.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDTO {
    private String fullName;

    private String username;

    private UserStatus status;

}
