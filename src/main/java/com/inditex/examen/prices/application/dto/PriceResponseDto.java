package com.inditex.examen.prices.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class PriceResponseDto {
    private Long brandId;
    private Date startDate;
    private Date endDate;
    private Long productId;
    private BigDecimal price;
    private BigDecimal rate;

}
