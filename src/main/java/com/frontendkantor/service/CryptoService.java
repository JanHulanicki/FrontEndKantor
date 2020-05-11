package com.frontendkantor.service;

import com.frontendkantor.domain.crypto.CryptoCurrencyDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static com.frontendkantor.config.CoreConfig.BACKEND_URL;
import static java.util.Optional.ofNullable;

@Service
public class CryptoService {
    private static final String CRYPTO_ENDPOINT = BACKEND_URL + "/v1//crypto";
    private RestTemplate restTemplate = new RestTemplate();

    public List<CryptoCurrencyDto> getAllCrypto() {
        URI uri = UriComponentsBuilder.fromHttpUrl(CRYPTO_ENDPOINT).build().encode().toUri();

        CryptoCurrencyDto[] allCryptoResponse = restTemplate.getForObject(uri, CryptoCurrencyDto[].class);
        System.out.println(Arrays.asList(ofNullable(allCryptoResponse).orElse(new CryptoCurrencyDto[0])).toString());
        return Arrays.asList(ofNullable(allCryptoResponse).orElse(new CryptoCurrencyDto[0]));
    }
}