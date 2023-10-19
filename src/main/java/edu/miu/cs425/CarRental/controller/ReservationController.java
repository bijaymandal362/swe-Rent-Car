package edu.miu.cs425.CarRental.controller;

import edu.miu.cs425.CarRental.dto.UpdateReservationRequest;
import edu.miu.cs425.CarRental.model.Reservation;
import edu.miu.cs425.CarRental.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/car-rental/reservations")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping()
    public List<Reservation> listAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/getByCustomer/{customerId}")
    public List<Reservation> listAllReservationsByCustomerId(@PathVariable Long customerId) {
        return reservationService.getReservationsByCustomerId(customerId);
    }

    @PostMapping()
    public Reservation makeNewReservation(Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PostMapping(value = "/cancel")
    public void cancelReservation(Long reservationId) {
        reservationService.cancelReservationById(reservationId);
    }

    @GetMapping(value = "/{reservationId}")
    public Optional<Reservation> viewReservationById(@PathVariable Long reservationId){
        return reservationService.viewReservationById(reservationId);
    }

    @DeleteMapping(value = "/{reservationId}")
    public void deleteById(@PathVariable Long reservationId){
        reservationService.deleteReservationById(reservationId);
    }

    @PutMapping(value = "/{reservationId}")
    public void updateReservationById(@RequestBody UpdateReservationRequest reservationRequest, @PathVariable Long reservationId){
        reservationService.updateReservationById(reservationRequest,reservationId);
    }
}
