package com.frontendkantor.domain.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCurrencyDto {
    @SerializedName("Realtime Currency Exchange Rate")
    @Expose
    public RealtimeCurrencyExchangeRatedDto realtimeCurrencyExchangeRatedDto;

    @Override
    public String toString() {
        return "CryptoCurrencyDto{" +
                "realtimeCurrencyExchangeRate=" + realtimeCurrencyExchangeRatedDto +
                '}';
    }
}
