package edu.miu.cs425.CarRental.dto;

import edu.miu.cs425.CarRental.util.enums.VehicleFuelType;
import edu.miu.cs425.CarRental.util.enums.VehicleTransmission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class VehicleRequest {

    private String make;

    private String model;

    private int year;

    private String color;

    private int numberOfSeats;

    private double price;

    private VehicleTransmission transmission;

    private VehicleFuelType fuelType;

    private boolean availability;

    private String plateNumber;
}
