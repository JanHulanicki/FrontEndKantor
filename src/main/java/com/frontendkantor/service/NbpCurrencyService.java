package com.frontendkantor.service;

import com.frontendkantor.domain.nbp.NbpCurrencyDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static com.frontendkantor.config.CoreConfig.BACKEND_URL;
import static java.util.Optional.ofNullable;

@Service
public class NbpCurrencyService {
    private static final String NBP_ENDPOINT = BACKEND_URL + "/v1/NbpCurrency";
    private RestTemplate restTemplate = new RestTemplate();

    public List<NbpCurrencyDto> getAllNbpCurrencies() {
        URI uri = UriComponentsBuilder.fromHttpUrl(NBP_ENDPOINT).build().encode().toUri();

        NbpCurrencyDto[] allNbpResponse = restTemplate.getForObject(uri, NbpCurrencyDto[].class);
        System.out.println(Arrays.asList(ofNullable(allNbpResponse).orElse(new NbpCurrencyDto[0])).toString());
        return Arrays.asList(ofNullable(allNbpResponse).orElse(new NbpCurrencyDto[0]));
    }
}
