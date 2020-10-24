package com.productpickerservicepoc.models;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    public Integer user_id;

    @Column
    public String username;

    @Column
    public String created_at;

    public User(final Integer userId, final String username, final String createdAt) {
        this.user_id = userId;
        this.username = username;
        this.created_at = createdAt;
    }

    public User() {
        //
    }

    public Integer getUserId() {
        return this.user_id;
    }

    public void setUserId(Integer userId) {
        this.user_id = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedAt() {
        return this.created_at;
    }

    public void setCreatedAt(String createdAt) {
        this.created_at = createdAt;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("user_id", this.getUserId())
                .append("username", this.getUsername())
                .append("created_at", this.getCreatedAt())
                .toString();
    }
}
