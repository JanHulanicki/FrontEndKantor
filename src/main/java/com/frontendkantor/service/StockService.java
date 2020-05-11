package com.frontendkantor.service;

import com.frontendkantor.domain.stock.StockDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static com.frontendkantor.config.CoreConfig.BACKEND_URL;
import static java.util.Optional.ofNullable;

@Service
public class StockService {
    private static final String STOCK_ENDPOINT = BACKEND_URL + "/v1/stock";
    private RestTemplate restTemplate = new RestTemplate();

    public List<StockDto> getAllStock() {
        URI uri = UriComponentsBuilder.fromHttpUrl(STOCK_ENDPOINT).build().encode().toUri();

        StockDto[] allStockResponse = restTemplate.getForObject(uri, StockDto[].class);
        System.out.println(Arrays.asList(ofNullable(allStockResponse).orElse(new StockDto[0])).toString());
        return Arrays.asList(ofNullable(allStockResponse).orElse(new StockDto[0]));
    }
}