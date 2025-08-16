package com.wipro.gp.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wipro.gp.entities.Doctor;

import java.time.DayOfWeek;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // Fetch by partial name (case-insensitive)
    @Query("SELECT d FROM Doctor d WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Doctor> findByNameContainingIgnoreCase(String name);

    // Fetch doctors available on a given day
    @Query("SELECT d FROM Doctor d JOIN d.availableDays day WHERE day = :day")
    List<Doctor> findByAvailableDaysContaining(DayOfWeek day);
    
    @Query("SELECT d FROM Doctor d WHERE d.specialization = :specialization")
    List<Doctor> getDoctorsBySpecialization(String specialization);

    @Query(value = "SELECT * FROM Doctors WHERE specialization = :specialization ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Doctor getOneRandomDoctorBySpecialization(@Param("specialization") String specialization);
}
