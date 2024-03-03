package org.example.buoi3.controllers;


import org.example.buoi3.inputs.RoleDataInput;
import org.example.buoi3.outputs.RoleDataOutput;
import org.example.buoi3.services.RoleService;
import org.example.buoi3.services.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public ResponseEntity<?> getRoles(){
        List<RoleDataOutput> list= roleService.getRoles();
        return ResponseEntity.ok(list);
    }
    @PostMapping()
    public ResponseEntity<?>createRole(RoleDataInput roleDataInput){
        RoleDataOutput input= roleService.createRole(roleDataInput);
        return ResponseEntity.ok(input);

    }
}
