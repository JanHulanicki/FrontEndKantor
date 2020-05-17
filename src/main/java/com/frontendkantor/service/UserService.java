package com.frontendkantor.service;

import com.frontendkantor.domain.user.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.frontendkantor.config.CoreConfig.BACKEND_URL;

@Service
public class UserService {
    private static final String USER_ENDPOINT = BACKEND_URL + "v1/user";
    private RestTemplate restTemplate = new RestTemplate();

    public void saveUser(UserDto userDto) {
        restTemplate.postForObject(USER_ENDPOINT, userDto, UserDto.class);
    }
}
