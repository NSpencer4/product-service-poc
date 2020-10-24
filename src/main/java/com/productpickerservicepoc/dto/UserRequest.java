package com.productpickerservicepoc.dto;

import org.springframework.core.style.ToStringCreator;

public class UserRequest {
    private Integer id;
    private String username;
    private String createdAt;

    public Integer getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public String getCreatedAt() {
        return this.createdAt;
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
