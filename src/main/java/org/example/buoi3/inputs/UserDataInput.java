package org.example.buoi3.inputs;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class UserDataInput {
    private String name;
    private String username;
    private String password;
    private MultipartFile avatar;
    private List<MultipartFile> images;

    public UserDataInput() {
    }
    
    public UserDataInput(String name, String username, String password, MultipartFile avatar) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }
    
    public List<MultipartFile> getImages() {
        return images;
    }
    
    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
    
    public MultipartFile getAvatar() {
        return avatar;
    }
    
    public void setAvatar(MultipartFile avatar) {
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
}
