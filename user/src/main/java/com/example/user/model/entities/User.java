package com.example.user.model.entities;

import com.example.user.model.entities.base.BaseEntity;
import com.example.user.model.enums.Authority;
import com.example.user.model.enums.UserStatus;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Builder
public class User extends BaseEntity implements UserDetails {
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "username", updatable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "validation_code")
    private String validationCode;

    @Builder.Default
    @Column(name = "authority")
    @CollectionTable(
            name = "users_authorities",
            joinColumns = {@JoinColumn(name = "user_id")}
    )
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    private Set<Authority> authorities = Set.of(Authority.USER);

    @Builder.Default
    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserStatus status = UserStatus.INACTIVE;

    @Builder.Default
    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    @Override
    public boolean isEnabled() {
        return !this.deleted;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.status.equals(UserStatus.BLOCKED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
