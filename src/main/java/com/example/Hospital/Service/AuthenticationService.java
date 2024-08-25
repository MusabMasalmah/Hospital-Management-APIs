package com.example.Hospital.Service;

import com.example.Hospital.AuthClasses.AuthenticateRequest;
import com.example.Hospital.AuthClasses.AuthenticationResponse;
import com.example.Hospital.AuthClasses.RegisterRequest;
import com.example.Hospital.Models.Role;
import com.example.Hospital.Models.User;
import com.example.Hospital.Repositoris.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {
        var user = new User(
                request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Role.USER
        );

        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);

    }

    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        try {
            // Attempt to authenticate the user
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            // Find the user by email
            var user = userRepo.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));

            // Generate JWT token
            var jwtToken = jwtService.generateToken(user);

            // Return the authentication response with the token
            return new AuthenticationResponse(jwtToken);

        } catch (Exception e) {
            // Log the exception and rethrow it or return a meaningful error response
            System.out.println("Authentication failed: " + e.getMessage());
            throw e;
        }
    }

}
