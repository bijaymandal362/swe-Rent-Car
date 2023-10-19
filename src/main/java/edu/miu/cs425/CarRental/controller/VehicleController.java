package edu.miu.cs425.CarRental.controller;

import edu.miu.cs425.CarRental.dto.VehicleRequest;
import edu.miu.cs425.CarRental.exception.VehicleNotFoundException;
import edu.miu.cs425.CarRental.model.Vehicle;
import edu.miu.cs425.CarRental.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping(value = "/api/car-rental/vehicles")
public class VehicleController {

    private VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    //List all vehicles
    @GetMapping()
    public ResponseEntity<List<Vehicle>> listAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicle());
    }

    @GetMapping(value = "/{vehicleId}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long vehicleId) throws VehicleNotFoundException {
        return ResponseEntity.ok(vehicleService.getVehicleById(vehicleId));

    }
    @GetMapping(value = "/getByModel/{model}")
    public ResponseEntity<List<Vehicle>> getVehiclesByModel(@PathVariable String model) {
        return ResponseEntity.ok(vehicleService.getVehicleByModel(model));
    }
    @GetMapping(value = "/getByPrice/{price}")
    public ResponseEntity<List<Vehicle>> getVehiclesByPrice(@PathVariable double price) {
        return ResponseEntity.ok(vehicleService.getVehicleByPrice(price));
    }
    @GetMapping(value = "/get-available")
    public ResponseEntity<List<Vehicle>> getAvailableVehicles(){
        return ResponseEntity.ok(vehicleService.getAvailableVehicles());
    }

    @PutMapping(value = "/{vehicleId}")
    public  Vehicle updateVehicleById(@RequestBody VehicleRequest vehicle, @PathVariable Long vehicleId) {
        return  vehicleService.updateVehicleById(vehicle,vehicleId);
    }

    @PostMapping()
    public Vehicle addNewVehicle(@Valid @RequestBody VehicleRequest vehicle)  {
        return vehicleService.addNewVehicle(vehicle);
    }
    @DeleteMapping(value = "/{vehicleId}")
    public void deleteById(@PathVariable Long vehicleId) {
        vehicleService.deleteById(vehicleId);
    }
}
