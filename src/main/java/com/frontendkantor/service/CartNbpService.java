package com.frontendkantor.service;

import com.frontendkantor.domain.cart.CartCryptoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.frontendkantor.config.CoreConfig.BACKEND_URL;

@Service
public class CartNbpService {
    private static final String USER_ENDPOINT = BACKEND_URL + "v1/nbpcart";
    private RestTemplate restTemplate = new RestTemplate();

    public void saveUser(CartCryptoDto cartCryptoDto) {
        restTemplate.postForObject(USER_ENDPOINT, cartCryptoDto, CartCryptoDto.class);
    }
}
