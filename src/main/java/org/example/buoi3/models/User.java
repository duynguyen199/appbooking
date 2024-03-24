package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.buoi3.models.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "avatar")
    private String avatar;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Role> roles;
    
    @OneToMany(mappedBy = "user")
    private List<Images> images;

    public User() {
    }

    public User(Long id, Boolean status, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, String name, String username, String password, List<Role> roles) {
        super(id, status, createdAt, updatedAt, createdBy, updatedBy);
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(String name, String username, String password, List<Role> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    
    public User(String name, String username, String password, String avatar, List<Role> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.roles = roles;
    }
    
    public List<Images> getImages() {
        return images;
    }
    
    public void setImages(List<Images> images) {
        this.images = images;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
