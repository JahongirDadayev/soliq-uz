package com.example.user.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    ADMIN,
    USER,
    ROLE_INTERNAL_SERVICE;

    @Override
    public String getAuthority() {
        return this.name();
    }

}