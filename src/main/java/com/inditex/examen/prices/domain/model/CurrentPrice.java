package com.inditex.examen.prices.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class CurrentPrice {
    private Long brandId;
    private Date startDate;
    private Date endDate;
    private Long productId;
    private BigDecimal price;
    private BigDecimal rate;
}
