package edu.miu.cs425.CarRental.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.miu.cs425.CarRental.util.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentMethod;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastActionTime;
}
