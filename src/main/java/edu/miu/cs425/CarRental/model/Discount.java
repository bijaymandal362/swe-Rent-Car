package edu.miu.cs425.CarRental.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Table(name = "DISCOUNT")
public class Discount {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long discountId;

        private double percentage;

        private String code;

        private String description;

        @CreationTimestamp
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdAt;

        private String title;

        private String vehicleMake;
}
