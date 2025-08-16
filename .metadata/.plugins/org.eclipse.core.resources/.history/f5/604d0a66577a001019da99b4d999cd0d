package com.wipro.gp.feign;

import com.wipro.gp.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PATIENT-SERVICE", path = "/api/v1/patients")
public interface PatientClient {
    @GetMapping("/id/{id}")
    PatientDTO getPatientById(@PathVariable("id") Long id);
}
