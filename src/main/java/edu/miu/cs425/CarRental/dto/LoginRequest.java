package edu.miu.cs425.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping
public class LoginRequest {
    private String username;
    private String password;
}