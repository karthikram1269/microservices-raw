package com.wipro.gp.controller;

import com.wipro.gp.entities.Doctor;
import com.wipro.gp.service.DoctorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/save")
    public Doctor addDoctor(@Valid @RequestBody Doctor doctor) {
    	log.info("Received request to add a doctor details");
    	 return doctorService.addDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
    	log.info("Received request to get doctor details by Id");
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/search")
    public List<Doctor> getDoctorsByName(@RequestParam String name) {
    	log.info("Received request to get list of doctor's details by doctor's name");
        return doctorService.getDoctorsByName(name);
    }
    
    @GetMapping("/specialization")
    public List<Doctor> getDoctorsBySpecialization(@RequestParam String specialization) {
    	log.info("Received request to get a list of doctor's details by specilaization");
        return doctorService.getDoctorsBySpecialization(specialization);
    }
    
    // for appointment, recommends relevant doctor with specialization 
    
    @GetMapping("/getDocWithNote")
    public Doctor withNotefetchDoctorBySpecialization(@RequestParam String specialization) {
    	log.info("Received request to get doctor details according to patient condition");
    	return doctorService.withNotefetchDoctorBySpecialization(specialization);
    }

    @GetMapping("/available")
    public List<Doctor> getDoctorsByDay(@RequestParam DayOfWeek day) {
    	log.info("Received request to get a list of doctor's details by filtering day");
        return doctorService.getDoctorsByDay(day);
    }
}
