package com.itschulungen;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Log
public class CalculatorSimpleImpl implements Calculator {
	@Override
	public int sum(int... numbers) {
		log.info("sum() >> numbers=" + Arrays.toString(numbers));

		if (numbers == null || numbers.length != 2) {
			throw new IllegalArgumentException("can't sum numbers: exactly 2 numbers expected");
		}

		return numbers[0] + numbers[1];
	}
}