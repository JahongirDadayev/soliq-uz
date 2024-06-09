package com.example.auth.model.dtos.user;

import com.example.auth.model.dtos.base.BaseDTO;
import com.example.auth.model.enums.Authority;
import com.example.auth.model.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BaseDTO {
    private String fullName;

    private String username;

    private String password;

    private String validationCode;

    private Set<Authority> authorities;

    private UserStatus status;

    private boolean deleted;

}
