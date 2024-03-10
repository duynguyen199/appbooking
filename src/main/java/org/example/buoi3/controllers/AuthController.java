package org.example.buoi3.controllers;

import org.example.buoi3.inputs.AuthenticationRequest;
import org.example.buoi3.inputs.UserDataInput;
import org.example.buoi3.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDataInput userDataInput){
        return ResponseEntity.ok(authService.signup(userDataInput));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
}
