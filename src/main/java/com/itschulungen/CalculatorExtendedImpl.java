package com.itschulungen;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Primary
@Log
public class CalculatorExtendedImpl implements Calculator {
	@Override
	public int sum(int... numbers) {
		log.info("sum() >> numbers=" + Arrays.toString(numbers));

		if (numbers == null) {
			return 0;
		}

		return Arrays.stream(numbers).sum();
	}
}