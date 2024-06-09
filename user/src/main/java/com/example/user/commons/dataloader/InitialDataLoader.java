package com.example.user.commons.dataloader;

import com.example.user.model.entities.User;
import com.example.user.model.enums.Authority;
import com.example.user.model.enums.UserStatus;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class InitialDataLoader {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Bean
    public void init() {
        if (!userRepository.existsByUsername("internaluser@gmail.com")) {
            userRepository.save(User.builder()
                    .username("internaluser@gmail.com")
                    .fullName("Jahongir Dadayev")
                    .password(passwordEncoder.encode("Jahongir1234"))
                    .authorities(Collections.singleton(Authority.ROLE_INTERNAL_SERVICE))
                    .status(UserStatus.ACTIVE)
                    .build());
        }
    }

}
