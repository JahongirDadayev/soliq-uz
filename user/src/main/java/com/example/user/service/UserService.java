package com.example.user.service;

import com.example.user.commons.contants.ErrorMessages;
import com.example.user.commons.exception.GeneralApiException;
import com.example.user.model.dtos.UserCreateDto;
import com.example.user.model.dtos.UserDto;
import com.example.user.model.dtos.UserUpdateDto;
import com.example.user.model.entities.User;
import com.example.user.model.mappers.UserMapper;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Lazy
    private final AuthenticationManager authenticationManager;

    public User getByUsername(String username) throws UsernameNotFoundException {
        return (User) loadUserByUsername(username);
    }

    public User getById(UUID id) throws UsernameNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new GeneralApiException(String.format(ErrorMessages.NOT_FOUND, User.class.getSimpleName())));
    }

    public User checkUserCredentials(String username, String password) throws UsernameNotFoundException {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return (User) authenticate.getPrincipal();
    }

    public User createUserForServices(UserCreateDto createDto) {
        User user = userMapper.toEntity(createDto);
        return userRepository.save(user);
    }

    public UserDto updateUserForServices(UUID id, UserUpdateDto updateDto) {
        User user = getById(id);
        userMapper.updateEntityFromDto(user, updateDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new GeneralApiException(String.format(ErrorMessages.NOT_FOUND, User.class.getSimpleName())));
    }

}
