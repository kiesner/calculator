package com.itschulungen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorSimpleImplTest {
	CalculatorSimpleImpl calculator;

	@BeforeEach
	void setUp() {
		calculator = new CalculatorSimpleImpl();
	}

	@Test
	void testSum() {
		assertEquals(
			3,
			calculator.sum(1, 2)
		);
	}

	@Test
	void testSumWithNoParam() {
		assertThrows(
			IllegalArgumentException.class,
			() -> calculator.sum()
		);
	}

	@Test
	void testSumWith1Param() {
		assertThrows(
			IllegalArgumentException.class,
			() -> calculator.sum(1)
		);
	}

	@Test
	void testSumWith3Params() {
		assertThrows(
			IllegalArgumentException.class,
			() -> calculator.sum(1, 2, 3)
		);
	}

	@Test
	void testSumWithNull() {
		assertThrows(
			IllegalArgumentException.class,
			() -> calculator.sum(null)
		);
	}
}