package org.example.buoi3.mappers;

import org.example.buoi3.inputs.StoreDataInput;
import org.example.buoi3.models.Store;
import org.example.buoi3.outputs.StoreDataOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel ="spring")
public interface StoreMapper {
    @Mappings({
            @Mapping(target = "name", source ="input.name"),
            @Mapping(target = "address", source ="input.address"),
            @Mapping(target = "id", source = "id")

    })
    Store toStore (StoreDataInput input, Long id);


    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "rate", target = "rate")


    })
    StoreDataOutput toStoreDataOutput (Store store);

}
