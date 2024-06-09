package com.example.billing.commons.clients;

import com.example.billing.commons.clients.config.ClientConfiguration;
import com.example.billing.model.dtos.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.billing.commons.constants.RestConstants.BASE_URL;
import static com.example.billing.commons.constants.RestConstants.USER;

@FeignClient(name = "user", path = BASE_URL + USER, configuration = ClientConfiguration.class)
public interface UserClient {

    @GetMapping(path = "/for-services")
    User getByUsername(@RequestParam(name = "username") String username);

}
