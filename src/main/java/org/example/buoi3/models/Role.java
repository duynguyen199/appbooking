package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import org.example.buoi3.models.base.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "role")
@Entity
public class Role extends BaseEntity {


    private String name;

    @ManyToMany
    @JoinTable(name = "user_role")
    @JsonIgnore
    private List<User> users;

    public Role() {
    }

    public Role(Long id, Boolean status, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, String name, List<User> users) {
        super(id, status, createdAt, updatedAt, createdBy, updatedBy);
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
