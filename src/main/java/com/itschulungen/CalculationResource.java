package com.itschulungen;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources/calculation")
@CrossOrigin
@Log
public class CalculationResource {
	@Autowired
	private Calculator calculator;
	@Autowired
	private CalculationRepository calculationRepository;

	@GetMapping("/sum/{number1}/{number2}")
	public Calculation sum(
		@PathVariable int number1,
		@PathVariable int number2
	) {
		log.info("sum() >> number1=" + number1 + ", number2=" + number2);

		int numberSmaller = Math.min(number1, number2);
		int numberGreater = Math.max(number1, number2);

		return calculationRepository.findByOperationAndNumber1AndNumber2(Operation.SUM, numberSmaller, numberGreater)
			.orElseGet(() -> {
				int result = calculator.sum(numberSmaller, numberGreater);

				Calculation calculation = calculationRepository.save(
					new Calculation(Operation.SUM, numberSmaller, numberGreater, result)
				);

				return calculation;
			});
	}

	@GetMapping("/sum")
	public List<Calculation> sumAll() {
		log.info("sumAll()");

		return calculationRepository.findAllByOperation(Operation.SUM);
	}
}