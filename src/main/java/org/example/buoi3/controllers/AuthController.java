package org.example.buoi3.controllers;

import org.example.buoi3.inputs.AuthenticationRequest;
import org.example.buoi3.inputs.UserDataInput;
import org.example.buoi3.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(UserDataInput userDataInput){
        try {
            return ResponseEntity.ok(authService.signup(userDataInput));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
}
