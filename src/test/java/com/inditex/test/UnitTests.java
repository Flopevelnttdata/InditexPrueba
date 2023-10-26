package com.inditex.test;

import com.inditex.examen.prices.application.usecase.PickPriceUseCase;
import com.inditex.examen.prices.application.usecaseimpl.PickPriceUseCaseService;
import com.inditex.examen.prices.domain.exception.PriceException;
import com.inditex.examen.prices.domain.model.Price;
import com.inditex.examen.prices.domain.port.PricesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class UnitTests {

    @Mock
    PickPriceUseCase pickPriceUseCase;


    @Mock
    private PricesRepository pricesRepository;
    private PickPriceUseCaseService pickPriceUseCaseService;

    @BeforeEach
    void setUp() {
        pricesRepository = mock(PricesRepository.class);
        pickPriceUseCaseService = new PickPriceUseCaseService(pricesRepository);
    }
    @Test
    void testService_emptyList() throws PriceException {
        when(pricesRepository.findByIdAndDataRange(any(),anyLong())).thenReturn(Collections.<Price>emptyList());

        assertEquals(pickPriceUseCaseService.getPriceByDateAndProductId(any(), anyLong()), Optional.<Price>empty());
    }

    @Test
    void testService_rate() throws ParseException, PriceException {
        Date startDate=new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").parse("2020-06-16 09.00.00");
        Date endDate=new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").parse("2020-12-31 23.59.59");
        var price = new Price(1L,startDate , endDate,1L,35455L,
                0, new BigDecimal("35.50"), "EUR", BigDecimal.ZERO);
        when(pricesRepository.findByIdAndDataRange(any(),anyLong())).thenReturn(List.of(price));

        assertFalse(pickPriceUseCaseService.getPriceByDateAndProductId(any(), anyLong()).isEmpty());
    }

}
