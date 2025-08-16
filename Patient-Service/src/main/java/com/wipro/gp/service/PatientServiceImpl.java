package com.wipro.gp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.gp.entities.Patient;
import com.wipro.gp.exception.PatientNotFoundException;
import com.wipro.gp.repo.PatientRepository;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

	private final PatientRepository repository;

	@Override
	public Patient registerPatient(Patient patient) {
		return repository.save(patient);
	}

	@Override
	public Patient getPatient(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
	}

	@Override
	public Patient updatePatient(Long id, Patient patient) {
	    Patient existing = getPatient(id);

	    if (patient.getPatientFullName() != null)
	        existing.setPatientFullName(patient.getPatientFullName());

	    if (patient.getPhone() != null)
	        existing.setPhone(patient.getPhone());

	    if (patient.getEmail() != null)
	        existing.setEmail(patient.getEmail());

	    if (patient.getInsuranceNumber() != null)
	        existing.setInsuranceNumber(patient.getInsuranceNumber());

	    if (patient.getGender() != null)
	        existing.setGender(patient.getGender());

	    if (patient.getAddress() != null)
	        existing.setAddress(patient.getAddress());

	    return repository.save(existing);
	}


	@Override
	public Page<Patient> searchPatientsByName(String patientFullName, Pageable pageable) {
		return repository.findByFullNameContainingIgnoreCase(patientFullName, pageable);
	}
}