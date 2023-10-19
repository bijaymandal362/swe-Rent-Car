package edu.miu.cs425.CarRental.auth;

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
public class AuthenticationRequest {

    private String userName;

    private String password;
}
