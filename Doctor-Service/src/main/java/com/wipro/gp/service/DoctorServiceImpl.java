package com.wipro.gp.service;
import org.springframework.stereotype.Service;

import com.wipro.gp.entities.Doctor;
import com.wipro.gp.exception.DoctorNotFoundException;
import com.wipro.gp.repo.DoctorRepository;

import java.time.DayOfWeek;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found"));
        
    }

    public List<Doctor> getDoctorsByName(String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Doctor> getDoctorsByDay(DayOfWeek day) {
        return doctorRepository.findByAvailableDaysContaining(day);
    }

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getDoctorsBySpecialization(String specialization) {
		return doctorRepository.getDoctorsBySpecialization(specialization);
	}
	
	

	@Override
	public Doctor withNotefetchDoctorBySpecialization(String specialization) {

			
		if(specialization != null) {
			return doctorRepository.getOneRandomDoctorBySpecialization(specialization);
		}

	    // Return null or throw an exception if no matching doctor is found
	    throw new DoctorNotFoundException(specialization+" is not found");
	}
}
