package com.inditex.examen.prices.application.mapper;

import com.inditex.examen.prices.application.dto.PriceResponseDto;
import com.inditex.examen.prices.domain.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceResponseMapper {
    PriceResponseDto toDto(Price price);

}
