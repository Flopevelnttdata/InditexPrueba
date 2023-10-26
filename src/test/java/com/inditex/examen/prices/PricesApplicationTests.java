package com.inditex.examen.prices;

import com.inditex.examen.prices.application.usecase.PickPriceUseCase;
import com.inditex.examen.prices.domain.exception.PriceException;
import com.inditex.examen.prices.domain.model.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PricesApplicationTests {

	@Autowired
	private PickPriceUseCase pickPriceUseCase;

	@Test
	void contextLoads() {
	}

	@Test
	void TestCase1() throws ParseException, PriceException {
		checkPrice("2020-06-14 10.00.00",35455L,"35.5");
	}

	@Test
	void TestCase2() throws ParseException, PriceException {
		checkPrice("2020-06-14 16.00.00",35455L,"25.45");

	}

	@Test
	void TestCase3() throws ParseException, PriceException {
		checkPrice("2020-06-15 09.00.00",35455L,"30.5");
	}

	@Test
	void TestCase4() throws ParseException, PriceException {
		checkPrice("2020-06-15 10.00.00",35455L,"30.5");
	}

	@Test
	void TestCase5() throws ParseException, PriceException {
		checkPrice("2020-06-16 09.00.00",35455L,"38.95");

	}

	@Test
	void noResult() throws ParseException, PriceException {
		Date fecha=new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").parse("2020-06-16 09.00.00");
		Optional<Price> price = pickPriceUseCase.getPriceByDateAndProductId(fecha , 111111L);

		assertTrue(price.isEmpty());
	}

	private void checkPrice(String date, Long productId, String expectedResult) throws ParseException, PriceException {
		Date fecha=new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").parse(date);
		Optional<Price> price = pickPriceUseCase.getPriceByDateAndProductId(fecha, productId);

		assertTrue(price.isPresent());
		assertEquals(price.get().getPrice().compareTo(new BigDecimal(expectedResult)),0);
	}

}
