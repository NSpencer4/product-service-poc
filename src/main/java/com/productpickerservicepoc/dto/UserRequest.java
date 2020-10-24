package com.productpickerservicepoc.dto;

import org.springframework.core.style.ToStringCreator;

public class UserRequest {
    private Integer id;
    private String username;
    private String createdAt;

    public UserRequest(Integer id, String username, String createdAt) {
        this.id = id;
        this.username = username;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("getId", this.getId())
                .append("username", this.getUsername())
                .append("created_at", this.getCreatedAt())
                .toString();
    }
}
