package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.buoi3.models.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="service")

public class Service extends BaseEntity {

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "service")
    @JsonIgnore
    private List<StoreService> storeServices;

    public Service(){}

    public Service(Long id, Boolean status, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, String name, List<StoreService> storeServices) {
        super(id, status, createdAt, updatedAt, createdBy, updatedBy);
        this.name = name;
        this.storeServices = storeServices;
    }

    public Service(String name, List<StoreService> storeServices) {
        this.name = name;
        this.storeServices = storeServices;
    }
}
