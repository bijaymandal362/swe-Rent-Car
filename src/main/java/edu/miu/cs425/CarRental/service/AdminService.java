package edu.miu.cs425.CarRental.service;


import edu.miu.cs425.CarRental.dto.LoginRequest;
import edu.miu.cs425.CarRental.dto.LoginResponse;
import edu.miu.cs425.CarRental.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AdminService {

    Admin saveAdmin(Admin newAdmin);

    List<Admin> getAll();

    Optional<Admin> getAdminById(Long adminId);

    LoginResponse login(LoginRequest loginRequest);
}
