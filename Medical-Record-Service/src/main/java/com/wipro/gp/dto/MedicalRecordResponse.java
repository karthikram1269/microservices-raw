package com.wipro.gp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicalRecordResponse {
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private String prescription;
    private String fileName;
    private String note; 
    private PatientDTO patient;
    private DoctorDTO doctor;
}
