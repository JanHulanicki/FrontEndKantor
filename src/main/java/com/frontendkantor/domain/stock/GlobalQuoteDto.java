package com.frontendkantor.domain.stock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalQuoteDto {
    private Long _id;
    @SerializedName("01. symbol")
    @Expose
    private String symbol;
    @SerializedName("02. open")
    @Expose
    private BigDecimal open;
    @SerializedName("03. high")
    @Expose
    private BigDecimal high;
    @SerializedName("04. low")
    @Expose
    private BigDecimal low;
    @SerializedName("05. price")
    @Expose
    private BigDecimal price;
    @SerializedName("06. volume")
    @Expose
    private BigDecimal volume;
    @SerializedName("07. latest trading day")
    @Expose
    private String latestTradingDay;
    @SerializedName("08. previous close")
    @Expose
    private BigDecimal previousClose;
    @SerializedName("09. change")
    @Expose
    private BigDecimal change;

    @Override
    public String toString() {
        return "GlobalQuoteDto{" +
                "symbol='" + symbol + '\'' +
                ", Open=" + open +
                ", High=" + high +
                ", Low=" + low +
                ", Price=" + price +
                ", Volume=" + volume +
                ", LatestTradingDay=" + latestTradingDay +
                ", PreviousClose=" + previousClose +
                ", Change=" + change +
                '}';
    }
}
