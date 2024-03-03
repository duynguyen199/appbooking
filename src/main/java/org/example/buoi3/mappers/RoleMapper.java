package org.example.buoi3.mappers;

import org.example.buoi3.inputs.RoleDataInput;
import org.example.buoi3.models.Role;
import org.example.buoi3.outputs.RoleDataOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel ="spring")

public interface RoleMapper {
    @Mappings({
            @Mapping(target = "name", source = "role.name"),
            @Mapping(target = "id",source = "id")

            })
    Role toRole (RoleDataInput role, Long id);


    @Mappings({
            @Mapping(source = "name", target = "name")
    })
    RoleDataOutput toRoleDataOutput(Role role);
}

