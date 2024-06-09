package com.example.auth.commons.clients;

import com.example.auth.commons.clients.config.ClientConfiguration;
import com.example.auth.model.dtos.user.User;
import com.example.auth.model.dtos.user.UserCreateDto;
import com.example.auth.model.dtos.user.UserUpdateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "user", path = "/api/v1/user", configuration = ClientConfiguration.class)
public interface UserClient {

    @GetMapping(path = "/for-services")
    User getByUsername(@RequestParam(name = "username") String username);

    @GetMapping(path = "/for-services/check-credentials")
    User checkUserCredentials(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password);

    @PostMapping(path = "/for-services")
    User createUser(@RequestBody UserCreateDto userCreateDto);

    @PutMapping(path = "/{id}/for-services")
    User updateUserForServices(@PathVariable(name = "id") UUID id, @RequestBody UserUpdateDto userUpdateDto);

}
