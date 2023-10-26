package com.inditex.examen.prices.infrastructure.outputadapter;

import com.inditex.examen.prices.domain.model.Price;
import com.inditex.examen.prices.domain.port.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PricesRepositoryAdapter implements PricesRepository {
   private final PricesRepositoryJPA pricesRepositoryJPA;
   private final PricesEntityMapper pricesEntityMapper;

    @Override
    public List<Price> findByIdAndDataRange(Date date, Long productId) {
        return pricesRepositoryJPA.findByIdAndDataRange(date, productId).stream()
                .map(pricesEntityMapper::toDomain).toList();
    }
}
