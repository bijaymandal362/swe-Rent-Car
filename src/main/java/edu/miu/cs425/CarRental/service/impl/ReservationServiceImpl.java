package edu.miu.cs425.CarRental.service.impl;


import edu.miu.cs425.CarRental.dto.UpdateReservationRequest;
import edu.miu.cs425.CarRental.model.Reservation;
import edu.miu.cs425.CarRental.model.Vehicle;
import edu.miu.cs425.CarRental.repository.ReservationRepository;
import edu.miu.cs425.CarRental.repository.VehicleRepository;
import edu.miu.cs425.CarRental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByCustomerId(Long customerId) {
        return reservationRepository.findReservationsByCustomerId(customerId);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void cancelReservationById(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public Optional<Reservation> viewReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public void deleteReservationById(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public void updateReservationById(UpdateReservationRequest reservationRequest, Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        Vehicle vehicle = vehicleRepository.findById(reservationRequest.getVehicleId()).get();
        if (reservation != null) {
            reservation.setReturnDate(reservationRequest.getReturnDate());
            reservation.setStartDate(reservationRequest.getStartDate());
//            reservation.setVehicle(vehicle);
        }
    }
}
