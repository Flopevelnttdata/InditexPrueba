package com.inditex.examen.prices.application.usecase;

import com.inditex.examen.prices.domain.exception.PriceException;
import com.inditex.examen.prices.domain.model.Price;

import java.util.Date;
import java.util.Optional;

public interface PickPriceUseCase {

    Optional<Price> getPriceByDateAndProductId(Date requestDate, Long productId) throws PriceException;

}
