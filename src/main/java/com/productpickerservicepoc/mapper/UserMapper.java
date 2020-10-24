package com.productpickerservicepoc.mapper;

import com.productpickerservicepoc.dto.UserRequest;
import com.productpickerservicepoc.dto.UserResponse;
import com.productpickerservicepoc.models.User;

import java.sql.Timestamp;

public class UserMapper {
    public User map(UserRequest userRequest) {
        User newUser = new User();
        newUser.setUsername(userRequest.getUsername());
        newUser.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return newUser;
    }
    public UserResponse mapToUserResponse(User user) {
        return new UserResponse(user.getUserId(), user.getUsername(), user.getCreatedAt());
    }
}
