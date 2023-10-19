package edu.miu.cs425.CarRental.service;


import edu.miu.cs425.CarRental.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment makePayment(Payment payment);
    Payment viewPaymentById(Long paymentId);
}
