package com.example.user.controller;

import com.example.user.model.dtos.UserCreateDto;
import com.example.user.model.dtos.UserDto;
import com.example.user.model.dtos.UserUpdateDto;
import com.example.user.model.entities.User;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('ROLE_INTERNAL_SERVICE')")
    @GetMapping(path = "/for-services")
    public User getByUsernameForServices(@RequestParam(name = "username") String username) {
        return userService.getByUsername(username);
    }

    @PreAuthorize("hasRole('ROLE_INTERNAL_SERVICE')")
    @GetMapping(path = "/for-services/check-credentials")
    public User checkUserCredentials(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        return userService.checkUserCredentials(username, password);
    }

    @PreAuthorize("hasRole('ROLE_INTERNAL_SERVICE')")
    @PostMapping(path = "/for-services")
    public User createUserForServices(@RequestBody UserCreateDto userCreateDto) {
        return userService.createUserForServices(userCreateDto);
    }

    @PreAuthorize("hasRole('ROLE_INTERNAL_SERVICE')")
    @PutMapping(path = "/{id}/for-services")
    public UserDto updateUserForServices(@PathVariable(name = "id") UUID id, @RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateUserForServices(id, userUpdateDto);
    }

}
