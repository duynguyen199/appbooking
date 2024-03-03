package org.example.buoi3.services;

import org.example.buoi3.inputs.RoleDataInput;
import org.example.buoi3.outputs.RoleDataOutput;

import java.util.List;

public interface RoleService {
    List<RoleDataOutput> getRoles();
    RoleDataOutput createRole(RoleDataInput input);
}
