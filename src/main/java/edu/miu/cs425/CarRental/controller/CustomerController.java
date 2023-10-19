package edu.miu.cs425.CarRental.controller;


import edu.miu.cs425.CarRental.dto.CustomerRequest;
import edu.miu.cs425.CarRental.dto.LoginRequest;
import edu.miu.cs425.CarRental.dto.LoginResponse;
import edu.miu.cs425.CarRental.model.Customer;
import edu.miu.cs425.CarRental.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/car-rental/customers")
public class CustomerController {
    @Autowired
   private CustomerService customerService;

    @PostMapping("")
    public Customer createNewCustomer(@Valid @RequestBody CustomerRequest newCustomerRequest){
        return customerService.createCustomer(newCustomerRequest);
    }

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @PutMapping("/{customerId}")
    public Customer updateCustomer(@Valid @RequestBody Customer updateCustomer,@PathVariable Long customerId){
        return customerService.updateCustomer(updateCustomer,customerId);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(customerService.login(loginRequest),
                HttpStatus.OK);
    }
}
