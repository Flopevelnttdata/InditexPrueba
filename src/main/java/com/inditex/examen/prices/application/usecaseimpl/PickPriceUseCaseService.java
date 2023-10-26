package com.inditex.examen.prices.application.usecaseimpl;

import com.inditex.examen.prices.application.mapper.PriceResponseMapper;
import com.inditex.examen.prices.domain.exception.PriceException;
import com.inditex.examen.prices.domain.port.PricesRepository;
import com.inditex.examen.prices.domain.model.Price;
import com.inditex.examen.prices.application.usecase.PickPriceUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class PickPriceUseCaseService implements PickPriceUseCase {

    @Autowired
    PricesRepository pricesRepository;


    public PickPriceUseCaseService(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public Optional<Price> getPriceByDateAndProductId(Date requestDate, Long productId) throws PriceException {
        log.debug("Returning the PriceResponse");
        try {
            return getPriceRate(pricesRepository.findByIdAndDataRange(requestDate, productId));
        } catch(Exception ex) {
            log.error(ex.getMessage());
            throw new PriceException();

        }
    }

    private Optional<Price> getPriceRate(List<Price> priceList) {
        var price = priceList.stream().max(Comparator.comparing(Price::getPriority));
        Optional<BigDecimal> rate;
        //Calculamos el rate como el procentaje de la diferencia entre el precio actual y el anterior
        //Si solo tenemos un precio en la fecha dada devolvemos 0
        if (priceList.size() > 1) {
            rate = priceList.stream()
                    .sorted(Comparator.comparing(Price::getPriority).reversed())
                    .limit(2)
                    .map(Price::getPrice)
                    .reduce( (left,right) -> {
                                var aminusb = left.subtract(right);
                                var aplusb2 = left.add(right).divide(new BigDecimal("2"),2,RoundingMode.HALF_UP);
                                return aminusb.divide(aplusb2,2, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
                            }
                    );
        } else {
            rate = Optional.of(BigDecimal.ZERO);
        }
        if(price.isPresent()) {
            price.get().setRate(rate.orElse(BigDecimal.ZERO));
        }
        return price;
    }
}
