package com.inditex.examen.prices.infrastructure.inputadapter.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceOutputDto {
    private Long brandId;
    private Date startDate;
    private Date endDate;
    private Long productId;
    private BigDecimal price;
    private BigDecimal rate;
}
