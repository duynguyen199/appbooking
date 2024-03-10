package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.buoi3.models.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")

public class Customer extends BaseEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "password")
    private String password;

    // 1 customer có 1 list comment
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Comment> comments;

    public Customer(){}

    public Customer(Long id, Boolean status, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, String name, String phoneNumber, String address, Date birthday, String email, String gender, String password, List<Comment> comments) {
        super(id, status, createdAt, updatedAt, createdBy, updatedBy);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.comments = comments;
    }

    public Customer(String name, String phoneNumber, String address, Date birthday, String email, String gender, String password, List<Comment> comments) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.comments = comments;
    }
}
