package com.productpickerservicepoc.mapper;

import com.productpickerservicepoc.dto.UserDto;
import com.productpickerservicepoc.models.User;

import java.sql.Timestamp;

public class UserMapper {
    public User map(UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.username);
        newUser.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return newUser;
    }
}
