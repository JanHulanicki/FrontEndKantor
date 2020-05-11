package com.frontendkantor.domain.stock;

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
public class StockDto {
    @SerializedName("Global Quote")
    @Expose
    private GlobalQuoteDto globalQuoteDto;

    @Override
    public String toString() {
        return "StockDto{" +
                "globalQuote=" + globalQuoteDto +
                '}';
    }
}
