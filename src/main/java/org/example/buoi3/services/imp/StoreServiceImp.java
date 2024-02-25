package org.example.buoi3.services.imp;


import org.example.buoi3.exception.BadRequestException;
import org.example.buoi3.exception.NotFoundException;
import org.example.buoi3.inputs.StoreDataInput;
import org.example.buoi3.mappers.StoreMapper;
import org.example.buoi3.models.Store;
import org.example.buoi3.outputs.StoreDataOutput;
import org.example.buoi3.repositories.StoreRepository;
import org.example.buoi3.services.StoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImp implements StoreService {

    private final StoreRepository storeRepository;

    private final StoreMapper storeMapper;
    public StoreServiceImp(StoreRepository storeRepository,StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper=storeMapper;
    }

    @Override
    public List<StoreDataOutput> getAllStores() {


        List<Store> storeList = storeRepository.findAll();
        if(storeList.isEmpty()){
            throw new NotFoundException("List is empty");
        }
        List<StoreDataOutput> dataOutputList = new ArrayList<>();


        for (Store store :storeList) {
            StoreDataOutput storeDataOutput =storeMapper.toStoreDataOutput(store);

            dataOutputList.add(storeDataOutput);

        }
        return dataOutputList;
    }

    @Override
    public StoreDataOutput getStoreById(Long id) {
        return null;
    }

    @Override
    public StoreDataOutput createStore(StoreDataInput input) {
        Store store =storeMapper.toStore(input,null);
        if(store.getName().isEmpty()) {
            throw new BadRequestException("Store is empty");
        }
        List<Store> listName = storeRepository.findAllByName(input.getName());

        if(!listName.isEmpty()){
            for (Store s: listName) {
                if(s.getName().equals(input.getName())){
                    throw new BadRequestException("Name is duplicate");
                }
            }
        }
       Store result = storeRepository.save(store);

        return storeMapper.toStoreDataOutput(result);
    }
}
