package com.example.Hospital.Controllers;

import com.example.Hospital.AuthClasses.AuthenticateRequest;
import com.example.Hospital.AuthClasses.AuthenticationResponse;
import com.example.Hospital.AuthClasses.RegisterRequest;
import com.example.Hospital.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticateRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}
