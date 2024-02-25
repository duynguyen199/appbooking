package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.buoi3.models.base.BaseEntity;

import java.util.List;

@Entity
@Table(name = "store")

public class Store extends BaseEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "rate")
    private Double rate;

    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private List<Comment> comments;

    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private List<StoreService> storeServices;

    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<StoreService> getStoreServices() {
        return storeServices;
    }

    public void setStoreServices(List<StoreService> storeServices) {
        this.storeServices = storeServices;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
