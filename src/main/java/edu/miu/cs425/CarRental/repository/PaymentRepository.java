package edu.miu.cs425.CarRental.repository;

import edu.miu.cs425.CarRental.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
