package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.buoi3.models.base.BaseEntity;

import java.time.LocalDateTime;

import javax.persistence.*;
@Entity
@Table(name = "store_service")

public class StoreService extends BaseEntity {


    @ManyToOne
    @JoinColumn(name="id_store")
    @JsonIgnore
    private Store store;

    @ManyToOne
    @JoinColumn(name = "id_service")
    @JsonIgnore
    private Service service;

    public StoreService(Long id, Boolean status, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, Store store, Service service) {
        super(id, status, createdAt, updatedAt, createdBy, updatedBy);
        this.store = store;
        this.service = service;
    }

    public StoreService(Store store, Service service) {
        this.store = store;
        this.service = service;
    }

    public StoreService() {

    }
}
