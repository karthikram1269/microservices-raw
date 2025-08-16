package com.wipro.gp.entities;

import com.wipro.gp.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Long patientId;

    @Column(nullable = true)
    private String billId;

    @Column(nullable = false)  
    private Long appointmentId;     //needed for json

    @Column(nullable = true)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentType paymentType;   //needed for json

    @Column(nullable = true)
    private String paymentStatus; // SUCCESS ,FAILED, PENDING
}
