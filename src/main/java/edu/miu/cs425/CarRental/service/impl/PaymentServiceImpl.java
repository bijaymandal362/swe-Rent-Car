package edu.miu.cs425.CarRental.service.impl;

import edu.miu.cs425.CarRental.model.Payment;
import edu.miu.cs425.CarRental.repository.PaymentRepository;
import edu.miu.cs425.CarRental.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment makePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment viewPaymentById(Long paymentId) {
        return paymentRepository.getReferenceById(paymentId);
    }
}
