package com.inditex.examen.prices.infrastructure.inputadapter.api;

import com.inditex.examen.prices.domain.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceOutputMapper {
    PriceOutputDto toDto(Price current);
}
