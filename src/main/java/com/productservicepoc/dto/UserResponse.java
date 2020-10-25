package com.productservicepoc.dto;

import java.sql.Timestamp;

public class UserResponse {
    private Integer id;
    private String username;
    private Timestamp createdAt;

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(Timestamp timestamp) {
        this.createdAt = timestamp;
    }

    public UserResponse(Integer id, String username, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
