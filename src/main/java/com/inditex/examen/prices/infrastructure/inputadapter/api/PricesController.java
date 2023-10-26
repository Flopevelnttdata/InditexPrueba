package com.inditex.examen.prices.infrastructure.inputadapter.api;

import com.inditex.examen.prices.application.usecase.PickPriceUseCase;
import com.inditex.examen.prices.domain.exception.PriceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PricesController {

    @Autowired
    PriceOutputMapper priceApiMapper;
    @Autowired
    PickPriceUseCase pickPriceUseCase;
    @ExceptionHandler(PriceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping("/currentprice")
    public ResponseEntity<PriceOutputDto> getPrice(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH.mm.ss") Date searchDate,
                                                   @RequestParam Long productId) throws PriceException {
        log.info("Controller get price of product {} in date {}", searchDate, productId);
        return ResponseEntity.ok( pickPriceUseCase.getPriceByDateAndProductId(searchDate, productId)
                .map(p -> priceApiMapper.toDto(p)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Price Not Found")));
    }
}
