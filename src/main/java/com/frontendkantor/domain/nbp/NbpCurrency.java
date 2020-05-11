package com.frontendkantor.domain.nbp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "NBP_CURRENCIES")
public class NbpCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NBP_ID")
    private Long _id;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DATE")
    private String date;

    @Column(name = "MID")
    private BigDecimal mid;

    public NbpCurrency(String currency, String code, String date, BigDecimal mid) {
        this.currency = currency;
        this.code = code;
        this.date = date;
        this.mid = mid;
    }
}
