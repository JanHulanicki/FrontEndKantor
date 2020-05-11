package com.frontendkantor.domain.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RealtimeCurrencyExchangeRatedDto {
    @SerializedName("1. From_Currency Code")
    @Expose
    public String code;
    @SerializedName("2. From_Currency Name")
    @Expose
    public String currency;
    @SerializedName("5. Exchange Rate")
    @Expose
    public BigDecimal mid;
    @SerializedName("6. Last Refreshed")
    @Expose
    public String date;
    private Long _id;

    @Override
    public String toString() {
        return "RealtimeCurrencyExchangeRatedDto{" +
                "code='" + code + '\'' +
                ", currency='" + currency + '\'' +
                ", mid=" + mid +
                ", date='" + date + '\'' +
                '}';
    }
}
