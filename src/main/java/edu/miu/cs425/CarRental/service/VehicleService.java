package edu.miu.cs425.CarRental.service;



import edu.miu.cs425.CarRental.dto.VehicleRequest;
import edu.miu.cs425.CarRental.exception.VehicleNotFoundException;
import edu.miu.cs425.CarRental.model.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicle();
    Vehicle getVehicleById(Long vehicleId) throws VehicleNotFoundException;
    List<Vehicle> getVehicleByModel(String model);
    List<Vehicle> getVehicleByPrice(double price);
    List<Vehicle> getAvailableVehicles();
    Vehicle updateVehicleById(VehicleRequest vehicle, Long vehicleId);
    Vehicle addNewVehicle(VehicleRequest vehicle);
    void deleteById(Long vehicleId);

//    void updateVehicleStatus(Long vehicleId, VehicleStatus vehicleStatus);

}
