package com.itschulungen;

import com.itschulungen.util.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@IntegrationTest
public class CalculationRepositoryTest {
	@Autowired
	CalculationRepository calculationRepository;

	@Test
	@Transactional
	void testSave() {
		Calculation news = new Calculation(Operation.SUM, 3, 3, 6);

		news = calculationRepository.save(news);

		assertNotNull(
			news.getId()
		);
	}

	@Test
	void testFindAll() {
		List<Calculation> newsList = calculationRepository.findAll();

		assertEquals(
			2,
			newsList.size()
		);
	}

	// TODO add more tests here ;-)
}
