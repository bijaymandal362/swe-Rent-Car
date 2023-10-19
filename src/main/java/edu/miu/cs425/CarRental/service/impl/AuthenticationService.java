package edu.miu.cs425.CarRental.service.impl;

import edu.miu.cs425.CarRental.auth.AuthenticationRequest;
import edu.miu.cs425.CarRental.auth.AuthenticationResponse;
import edu.miu.cs425.CarRental.auth.RegisterRequest;
import edu.miu.cs425.CarRental.config.JwtService;
import edu.miu.cs425.CarRental.model.Role;
import edu.miu.cs425.CarRental.model.User;
import edu.miu.cs425.CarRental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .userRole(Role.ADMIN)
                .build();
        repository.save(user);
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        var user =repository.findByUserName(request.getUserName())
                .orElseThrow();
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
