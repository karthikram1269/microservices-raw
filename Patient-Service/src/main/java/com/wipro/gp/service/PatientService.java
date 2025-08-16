package com.wipro.gp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.gp.entities.Patient;

public interface PatientService {
    Patient registerPatient(Patient patient);
    Patient getPatient(Long id);
    Patient updatePatient(Long id, Patient patient);
    Page<Patient> searchPatientsByName(String patientFullName,Pageable pageable);
}