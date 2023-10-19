package edu.miu.cs425.CarRental.service.impl;


import edu.miu.cs425.CarRental.dto.LoginRequest;
import edu.miu.cs425.CarRental.dto.LoginResponse;
import edu.miu.cs425.CarRental.model.Admin;
import edu.miu.cs425.CarRental.repository.AdminRepository;
import edu.miu.cs425.CarRental.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin saveAdmin(Admin newAdmin) {
        return adminRepository.save(newAdmin);
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> getAdminById(Long adminId) {
        return adminRepository.findById(adminId);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<Admin> admin = adminRepository.findAdminByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        return new LoginResponse(admin.map(Admin::getId).orElse(null));
    }
}
