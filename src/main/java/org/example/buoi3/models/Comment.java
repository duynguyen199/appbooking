package org.example.buoi3.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.buoi3.models.base.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")

public class Comment extends BaseEntity {


    @Column(name = "content")
    private String content;

    // 1 customer có nhiều comment => 1 list comment mới có 1 đối tượng customer
    @ManyToOne
    @JoinColumn(name = "id_customer")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="id_store")
    @JsonIgnore
    private Store store;

    public Comment(){}
    public Comment(Long id, Boolean status, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, String content, Customer customer, Store store) {
        super(id, status, createdAt, updatedAt, createdBy, updatedBy);
        this.content = content;
        this.customer = customer;
        this.store = store;
    }

    public Comment(String content, Customer customer, Store store) {
        this.content = content;
        this.customer = customer;
        this.store = store;
    }
}
