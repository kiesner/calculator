package com.itschulungen;

import com.itschulungen.util.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@IntegrationTest
public class CalculationResourceTest {
	@LocalServerPort
	int port;

	RestClient restClient;

	@BeforeEach
	void setUp() {
		restClient = RestClient.builder()
			.baseUrl("http://localhost:{port}/resources/calculation")
			.defaultUriVariables(
				Map.of("port", port)
			)
			.build();
	}

	@Test
	void testSum() {
		ResponseEntity<Calculation> response = restClient
			.get()
			.uri("/sum/1/2")
			.retrieve()
			.toEntity(Calculation.class);
		Calculation calculation = response.getBody();

		assertEquals(
			HttpStatus.OK,
			response.getStatusCode()
		);

		assertTrue(
			MediaType.APPLICATION_JSON.equalsTypeAndSubtype(
				response.getHeaders().getContentType()
			)
		);

		assertEquals(
			3,
			calculation.getResult()
		);
	}

	@Test
	void testSumAll() {
		ResponseEntity<List<Calculation>> response = restClient
			.get()
			.uri("/sum")
			.retrieve()
			.toEntity(new ParameterizedTypeReference<>() {});
		List<Calculation> calculations = response.getBody();

		assertFalse(
			calculations.isEmpty()
		);
	}

	// TODO add more tests here ;-)
}
