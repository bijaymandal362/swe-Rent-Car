package edu.miu.cs425.CarRental.model;

import edu.miu.cs425.CarRental.util.enums.VehicleFuelType;
import edu.miu.cs425.CarRental.util.enums.VehicleTransmission;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "VEHICLE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;

    private String model;

    private Integer buildYear;

    private String color;

    private Integer numberOfSeats;

    private double price;

    private Boolean availability;

    private String plateNumber;

    @Enumerated(EnumType.STRING)
    private VehicleTransmission transmission;

    @Enumerated(EnumType.STRING)
    private VehicleFuelType fuelType;
}
