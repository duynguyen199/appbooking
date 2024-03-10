package org.example.buoi3.outputs.auth;

import java.util.List;

public class AuthenticationResponse {
    private String jwt;
    private Long userId;
    private String username;
    private List<String> roles;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String jwt, Long userId, String username, List<String> roles) {
        this.jwt = jwt;
        this.userId = userId;
        this.username = username;
        this.roles = roles;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
