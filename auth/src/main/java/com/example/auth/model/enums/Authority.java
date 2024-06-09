package com.example.auth.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    ADMIN,
    ROLE_INTERNAL_SERVICE,
    USER;

    @Override
    public String getAuthority() {
        return this.name();
    }

}