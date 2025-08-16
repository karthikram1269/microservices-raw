package com.wipro.gp.feign;

import com.wipro.gp.dto.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DOCTOR-SERVICE", path = "/api/v1/doctors")
public interface DoctorClient {
    @GetMapping("/{id}")
    DoctorDTO getDoctorById(@PathVariable("id") Long id);
}
