package edu.miu.cs425.CarRental.service;

import edu.miu.cs425.CarRental.dto.UpdateReservationRequest;
import edu.miu.cs425.CarRental.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByCustomerId(Long customerId);
    Reservation createReservation(Reservation reservation);
    void cancelReservationById( Long reservationId);
    Optional<Reservation> viewReservationById(Long reservationId);

    void deleteReservationById(Long reservationId);

    void updateReservationById(UpdateReservationRequest reservationRequest, Long reservationId);
}
