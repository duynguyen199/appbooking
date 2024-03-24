package org.example.buoi3.controllers;

import org.example.buoi3.outputs.UserDataOutput;
import org.example.buoi3.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<?> getUserDetail(@PathVariable("id")Long id){
        UserDataOutput userDataOutput = userService.getDetail(id);
        return ResponseEntity.ok(userDataOutput);
    }
}
