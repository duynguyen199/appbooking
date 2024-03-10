package org.example.buoi3.repositories;

import org.example.buoi3.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    List<Role> findAllByName(String name);
    Role findByName(String name);
}
