package com.itschulungen;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(
	name = "t_calculation",
	uniqueConstraints = @UniqueConstraint(columnNames = { "operation", "number1", "number2", "result" })
)
public class Calculation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private Operation operation;

	@Column(nullable = false)
	private int number1;

	@Column(nullable = false)
	private int number2;

	@Column(nullable = false)
	private int result;

	public Calculation(Operation operation, int number1, int number2, int result) {
		this(null, operation, number1, number2, result);
	}
}