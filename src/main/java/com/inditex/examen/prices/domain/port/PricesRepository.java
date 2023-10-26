package com.inditex.examen.prices.domain.port;

import com.inditex.examen.prices.domain.model.Price;

import java.util.Date;
import java.util.List;

public interface PricesRepository {
        List<Price> findByIdAndDataRange(Date date, Long productId);

}
