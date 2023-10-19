package edu.miu.cs425.CarRental.repository;


import edu.miu.cs425.CarRental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findCustomerByEmailAndPassword(String email, String password);
}

