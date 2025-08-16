package com.wipro.gp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.gp.entities.Appointment;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);
    Appointment getAppointment(Long id);
    Appointment getAppointmentsByPatientId(Long patientId);
    void cancelAppointment(Long id);
	Appointment rescheduleAppointment(Long id, Appointment appointment);
	Page<Appointment> getAppointmentsByDoctorId(Long doctorId, Pageable pageable);
}
