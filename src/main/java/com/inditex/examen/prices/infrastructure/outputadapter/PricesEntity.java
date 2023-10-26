package com.inditex.examen.prices.infrastructure.outputadapter;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="prices")
public class PricesEntity {
    @Column(name="brandid")
    private Long brandId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH.mm.ss")
    @Column(name="startdate")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH.mm.ss")
    @Column(name="enddate")
    private Date endDate;
    @Id
    @Column(name="pricelist")
    private Long priceList;
    @Column(name="productid")
    private Long productId;
    private Integer priority;
    @Column(scale = 2)
    private BigDecimal price;
    private String currency;
}
