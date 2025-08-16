package com.wipro.gp.entities;

import com.wipro.gp.enums.Gender;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String patientFullName;

	@Column(unique = true, length = 10)
	private String phone;

	@Column(unique = true)
	private String email;

	private String insuranceNumber;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String address;
}