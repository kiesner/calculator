package com.itschulungen;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CalculationRepository extends JpaRepository<Calculation, Long> {
	Optional<Calculation> findByOperationAndNumber1AndNumber2(Operation operation, int number1, int number2);
	List<Calculation> findAllByOperation(Operation operation);
}