package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.buoi3.models.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "role")
@Entity
public class Role extends BaseEntity {

    @Column(name = "name")
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
    
    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }
    
    public Role(String name) {
        this.name = name;
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
