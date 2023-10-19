package edu.miu.cs425.CarRental.controller;

import edu.miu.cs425.CarRental.model.Payment;
import edu.miu.cs425.CarRental.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/car-rental/payments")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping()
    public List<Payment> listPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{paymentId}")
    public Payment findPaymentById(@PathVariable Long paymentId) {
        return paymentService.viewPaymentById(paymentId);
    }

    @PostMapping()
    public Payment makePayment(@Valid @RequestBody Payment payment) {
        return paymentService.makePayment(payment);
    }
}

