package org.example.buoi3.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.buoi3.models.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "employee")


public class Employee extends BaseEntity {


    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private Date birthday;

    @Column(name="gender")
    private String gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "experience")
    private String experience;

    @ManyToOne
    @JoinColumn(name = "id_store")
    @JsonIgnore
    private Store store;

    public Employee(){}
    public Employee(Long id, Boolean status, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, String name, Date birthday, String gender, String phoneNumber, String email, String address, String experience, Store store) {
        super(id, status, createdAt, updatedAt, createdBy, updatedBy);
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.experience = experience;
        this.store = store;
    }

    public Employee(String name, Date birthday, String gender, String phoneNumber, String email, String address, String experience, Store store) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.experience = experience;
        this.store = store;
    }
}
