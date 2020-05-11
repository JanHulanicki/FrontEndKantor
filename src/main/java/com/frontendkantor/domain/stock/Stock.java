package com.frontendkantor.domain.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NYSE_STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STOCK_ID")
    private Long _id;
    @Column(name = "STOCK")
    private String stock;
    @Column(name = "code")
    private String code;
    @Column(name = "STOCK_DATE")
    private String date;
    @Column(name = "mid")
    private BigDecimal mid;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "open")
    private BigDecimal Open;
    @Column(name = "high")
    private BigDecimal high;
    @Column(name = "low")
    private BigDecimal low;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "volume")
    private BigDecimal volume;
    @Column(name = "latesTradingDay")
    private String latestTradingDay;
    @Column(name = "previousClose")
    private BigDecimal previousClose;
    @Column(name = "_CHANGE")//ok
    private BigDecimal change;

    public Stock(String stock, String symbol, String date, BigDecimal mid) {
        this.stock = stock;
        this.symbol = symbol;
        this.date = date;
        this.mid = mid;
    }
}
