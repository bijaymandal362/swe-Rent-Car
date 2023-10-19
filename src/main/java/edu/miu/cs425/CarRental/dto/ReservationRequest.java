package edu.miu.cs425.CarRental.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.miu.cs425.CarRental.util.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ReservationRequest {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnDate;
    private ReservationStatus status;
    private Long customerId;
    private Long vehicleId;
}
