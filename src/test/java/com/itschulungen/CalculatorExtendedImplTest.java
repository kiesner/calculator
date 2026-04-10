package com.itschulungen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorExtendedImplTest {
	CalculatorExtendedImpl calculator;

	@BeforeEach
	void setUp() {
		calculator = new CalculatorExtendedImpl();
	}

	@Test
	void testSum() {
		assertEquals(
			6,
			calculator.sum(1, 2, 3)
		);
	}

	@Test
	void testSumWithNull() {
		assertEquals(
			0,
			calculator.sum(null)
		);
	}
}