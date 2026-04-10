package com.itschulungen;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log
public class DBInitializer {
	@Autowired
	private CalculationRepository calculationRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		log.info("init()");

		calculationRepository.saveAll(
			List.of(
				new Calculation(Operation.SUM, 1, 1, 2),
				new Calculation(Operation.SUM, 2, 2, 4)
			)
		);
	}
}