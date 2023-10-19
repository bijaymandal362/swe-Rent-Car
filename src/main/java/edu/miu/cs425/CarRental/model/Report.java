package edu.miu.cs425.CarRental.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.miu.cs425.CarRental.util.enums.ReportStatus;
import edu.miu.cs425.CarRental.util.enums.ReportType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="REPORT")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reportUrl;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private ReportStatus status;
    @Enumerated(EnumType.STRING)
    private ReportType type;

    @ManyToOne
    private Admin admin;
}
