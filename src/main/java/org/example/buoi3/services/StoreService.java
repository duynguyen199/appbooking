package org.example.buoi3.services;

import org.example.buoi3.inputs.StoreDataInput;
import org.example.buoi3.models.Store;
import org.example.buoi3.outputs.StoreDataOutput;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StoreService {

    List<StoreDataOutput> getAllStores();

    StoreDataOutput getStoreById(Long id);

    StoreDataOutput createStore(StoreDataInput input);


}
