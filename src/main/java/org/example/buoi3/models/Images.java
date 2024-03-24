package org.example.buoi3.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.buoi3.models.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "images")
public class Images extends BaseEntity {
    @Column(name = "link")
    private String link;
    
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "id_user")
    private User user;
    
    public Images() {
    }
    
    public Images(Long id, Boolean status, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, String link, User user) {
        super(id, status, createdAt, updatedAt, createdBy, updatedBy);
        this.link = link;
        this.user = user;
    }
    
    public Images(String link, User user) {
        this.link = link;
        this.user = user;
    }
    
    public String getLink() {
        return link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}
