package edu.miu.cs425.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class DiscountRequest {
    private double percentage;
    private String code;
    private String description;
    private String title;
    private String vehicleMake;
}
