package edu.miu.cs425.CarRental.controller;


import edu.miu.cs425.CarRental.dto.LoginRequest;
import edu.miu.cs425.CarRental.dto.LoginResponse;
import edu.miu.cs425.CarRental.model.Admin;
import edu.miu.cs425.CarRental.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/car-rental/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping()
    public ResponseEntity<List<Admin>> listStudent(){
        return ResponseEntity.ok(adminService.getAll());
    }

    @GetMapping(value ={"/{adminId}"})
    public ResponseEntity<Optional<Admin>> getStudentById(@PathVariable Long adminId){
        return ResponseEntity.ok(adminService.getAdminById(adminId));
    }

    @PostMapping()
    public ResponseEntity<Admin> addNewAdmin(@Valid @RequestBody Admin admin){
        return new ResponseEntity<>(adminService.saveAdmin(admin),
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(adminService.login(loginRequest),
                HttpStatus.OK);
    }
}
