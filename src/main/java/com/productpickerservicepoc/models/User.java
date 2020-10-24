package com.productpickerservicepoc.models;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer user_id;

    @Column
    private String username;

    @Column
    private Timestamp created_at;

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

    public Timestamp getCreatedAt() {
        return this.created_at;
    }

    public void setCreatedAt(Timestamp createdAt) {
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
