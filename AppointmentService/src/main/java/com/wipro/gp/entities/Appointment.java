package com.wipro.gp.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.wipro.gp.enums.AppointmentStatus;

@Entity
@Table(
	    name = "appointments",
	    uniqueConstraints = @UniqueConstraint(columnNames = {"patientId", "appointmentDateTime"})
	)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long patientId;
    
    @Column(nullable = true)
    private Long doctorId;
    
    @Column(nullable = true)
    private String  specialization;

    @Column(nullable = false)
    private LocalDateTime appointmentDateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status;

    @Column(length = 2000)
    private String notes;

    @PrePersist
    public void prePersist() {
        if (appointmentDateTime == null) {
            appointmentDateTime = LocalDateTime.now();
        }
    }
}
