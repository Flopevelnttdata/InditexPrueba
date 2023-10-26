package com.inditex.examen.prices.infrastructure.outputadapter;

import com.inditex.examen.prices.domain.model.Price;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PricesEntityMapper {

    PricesEntity toDto(Price price);

    Price toDomain(PricesEntity pricesEntity);

}
