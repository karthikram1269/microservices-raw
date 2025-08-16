package com.wipro.gp.controller;

import com.wipro.gp.entities.Appointment;
import com.wipro.gp.exception.AppointmentNotFoundException;
import com.wipro.gp.services.AppointmentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
	private final AppointmentService service;

	@CircuitBreaker(name = "bookAppointment", fallbackMethod = "bookFallback")
	@Retry(name = "bookAppointment")
	@RateLimiter(name = "bookAppointment")
	@PostMapping("/add")
	public Appointment bookAppointment(@Valid @RequestBody Appointment appointment) {
		log.info("Received request to book an appointment");
		return service.bookAppointment(appointment);
	}

	public Appointment bookFallback(Appointment appointment, Throwable t) {
		throw new AppointmentNotFoundException("Service temporarily unavailable: " + t.getMessage());
	}

	@GetMapping("/{id}")
	public Appointment getAppointmentById(@PathVariable Long id) {
		log.info("Received request to get apointment details");
		return service.getAppointment(id);
	}

	@GetMapping("/patient/{patientId}")
	public Appointment getByPatientId(@PathVariable Long patientId) {
		log.info("Received request to get appointment details by patientId");
		return service.getAppointmentsByPatientId(patientId);
	}

	@GetMapping("/doctor/{doctorId}")
	public Page<Appointment> getByDoctorId(@PathVariable Long doctorId, Pageable pageable) {
		log.info("Received request to get no of  appointment details by their Id");
		return service.getAppointmentsByDoctorId(doctorId, pageable);
	}

	@PutMapping("/{id}/reschedule")
	public Appointment reschedule(@PathVariable Long id, Appointment appointment) {
		log.info("Received request to reschedule the appointment");
		return service.rescheduleAppointment(id, appointment);
	}

	@DeleteMapping("/{id}")
	public void cancel(@PathVariable Long id) {
		log.info("Received request to cancel appointment");
		service.cancelAppointment(id);
	}
}