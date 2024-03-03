package org.example.buoi3.services.imp;

import org.example.buoi3.exception.BadRequestException;
import org.example.buoi3.exception.NotFoundException;
import org.example.buoi3.inputs.RoleDataInput;
import org.example.buoi3.mappers.RoleMapper;
import org.example.buoi3.models.Role;
import org.example.buoi3.outputs.RoleDataOutput;
import org.example.buoi3.repositories.RoleRepository;
import org.example.buoi3.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }


    @Override
    public List<RoleDataOutput> getRoles() {
        List<Role> roles = roleRepository.findAll();
        if(roles.isEmpty()){
            throw new NotFoundException("Role is empty");
        }
        List<RoleDataOutput> dataOutputList = new ArrayList<>();

        for(Role role: roles){
            RoleDataOutput roleDataOutput= roleMapper.toRoleDataOutput(role);

            dataOutputList.add(roleDataOutput);
        }

        return dataOutputList;
    }

    @Override
    public RoleDataOutput createRole(RoleDataInput input) {
        Role role = roleMapper.toRole(input,null);
        if(role.getName().isEmpty()){
            throw new BadRequestException("Role is empty");


        }

        Role result = roleRepository.save(role);

        return roleMapper.toRoleDataOutput(result);
    }
}
