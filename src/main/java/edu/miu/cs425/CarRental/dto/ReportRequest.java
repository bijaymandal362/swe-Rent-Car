package edu.miu.cs425.CarRental.dto;


import edu.miu.cs425.CarRental.util.enums.ReportStatus;
import edu.miu.cs425.CarRental.util.enums.ReportType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportRequest {
    private LocalDate startDate;
    private ReportStatus status;
    private ReportType type;
    private Long adminId;
}
