package com.productpickerservicepoc.mapper;

import com.productpickerservicepoc.dto.UserRequest;
import com.productpickerservicepoc.dto.UserResponse;
import com.productpickerservicepoc.models.User;

import java.sql.Timestamp;

public class UserMapper {
    public User map(UserRequest userRequest) {
        return new User(userRequest.getId(), userRequest.getUsername(), new Timestamp(System.currentTimeMillis()));
    }
    public UserResponse mapToUserResponse(User user) {
        return new UserResponse(user.getUser_id(), user.getUsername(), user.getCreated_at());
    }
}
