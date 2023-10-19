package edu.miu.cs425.CarRental.service.impl;

import edu.miu.cs425.CarRental.dto.CustomerRequest;
import edu.miu.cs425.CarRental.dto.LoginRequest;
import edu.miu.cs425.CarRental.dto.LoginResponse;
import edu.miu.cs425.CarRental.model.Customer;
import edu.miu.cs425.CarRental.repository.CustomerRepository;
import edu.miu.cs425.CarRental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerRequest newCustomerRequest) {

        Customer customer = new Customer(null,newCustomerRequest.getFirstName(),newCustomerRequest.getLastName(),
                newCustomerRequest.getEmail(),null,newCustomerRequest.getPassword(),null);
        return this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer updateCustomer(Customer updateCustomerReq, Long customerId) {
        Customer customer = this.customerRepository.findById(customerId).get();
        if(customer != null) {
            customer.setEmail(updateCustomerReq.getEmail());
            customer.setPhone(updateCustomerReq.getPhone());
            customer.setDriverLicense(updateCustomerReq.getDriverLicense());
            customer.setFirstName(updateCustomerReq.getFirstName());
            customer.setLastName(updateCustomerReq.getLastName());
            return customerRepository.save(customer);
        }
       return customer;
    }

    @Override
    public void deleteCustomer(Long customerId) {customerRepository.deleteById(customerId);}

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<Customer> customer = customerRepository.findCustomerByEmailAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        return new LoginResponse(customer.map(Customer::getId).orElse(null));
    }
}
