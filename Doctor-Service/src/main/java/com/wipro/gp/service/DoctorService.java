package com.wipro.gp.service;

import java.time.DayOfWeek;
import java.util.List;

import com.wipro.gp.entities.Doctor;

public interface DoctorService {

	List<Doctor> getDoctorsByDay(DayOfWeek day);

	List<Doctor> getDoctorsByName(String name);

	Doctor getDoctorById(Long id);

	Doctor addDoctor(Doctor doctor);

	List<Doctor> getDoctorsBySpecialization(String specialization);

	// for appointment
	Doctor withNotefetchDoctorBySpecialization(String specialization);
	
	

}
