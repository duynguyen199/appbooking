package org.example.buoi3.controllers;

import org.example.buoi3.inputs.StoreDataInput;
import org.example.buoi3.outputs.StoreDataOutput;
import org.example.buoi3.services.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllStoreList(){
        List<StoreDataOutput> listStore= storeService.getAllStores();
        return ResponseEntity.ok(listStore);
    }
    @PostMapping()
    public ResponseEntity<?> createStore(StoreDataInput input){
        StoreDataOutput storeDataOutput= storeService.createStore(input);
        return ResponseEntity.ok(storeDataOutput);
    }

}
