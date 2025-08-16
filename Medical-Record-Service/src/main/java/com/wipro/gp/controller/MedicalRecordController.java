package com.wipro.gp.controller;

import com.wipro.gp.entities.MedicalRecord;
import com.wipro.gp.exception.MedicalRecordNotFoundException;
import com.wipro.gp.services.MedicalRecordService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService service;

    @CircuitBreaker(name = "addRecordFromAppointment", fallbackMethod = "addRecordFallback")
	@Retry(name = "addRecordFallback")
	@RateLimiter(name = "addRecordFallback")
    @PostMapping("/save")
    public MedicalRecord saveRecord (@Valid @RequestBody MedicalRecord record) {
    	log.info("Received request to save medical record details");
        return service.saveRecord(record);
    }
    
    public MedicalRecord addRecordFallback(MedicalRecord record, Throwable t) {
		throw new MedicalRecordNotFoundException("Service temporarily unavailable: " + t.getMessage());
	}

    @GetMapping("/{id}")
    public MedicalRecord getRecord(@PathVariable Long id) {
    	log.info("Received request to get medical record details");
        return service.getRecord(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<MedicalRecord> getByPatient(@PathVariable Long patientId) {
    	log.info("Received request to get patient details by Id ");
        return service.getRecordsByPatient(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<MedicalRecord> getByDoctor(@PathVariable Long doctorId) {
    	log.info("Received request to get doctor details by Id");
        return service.getRecordsByDoctor(doctorId);
    }

    @GetMapping("/appointment/{appointmentId}")
    public List<MedicalRecord> getByAppointment(@PathVariable Long appointmentId) {
    	log.info("Received request to get appointment details by Id");
        return service.getRecordsByAppointment(appointmentId);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
    	log.info("Received request to delete medical record ");
        service.deleteRecord(id);
    }

}
