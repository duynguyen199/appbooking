package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.example.buoi3.models.base.BaseEntity;

import java.util.List;

@Table(name = "role")
@Entity
public class Role extends BaseEntity {

    private String name;

    @ManyToMany
    @JoinTable(name = "user_role")
    @JsonIgnore
    private List<User> users;
}
