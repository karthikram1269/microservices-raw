package com.wipro.gp.services;

import com.wipro.gp.entities.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecord saveRecord(MedicalRecord record);
    MedicalRecord getRecord(Long id);
    List<MedicalRecord> getRecordsByPatient(Long patientId);
    List<MedicalRecord> getRecordsByDoctor(Long doctorId);
    List<MedicalRecord> getRecordsByAppointment(Long appointmentId);
    void deleteRecord(Long id);
}
