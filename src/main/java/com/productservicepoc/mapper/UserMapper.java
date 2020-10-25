package com.productservicepoc.mapper;

import com.productservicepoc.dto.UserDto;
import com.productservicepoc.models.User;

import java.sql.Timestamp;

public class UserMapper {
    public User mapUserDtoToUser(UserDto UserDto) {
        return new User(UserDto.getId(), UserDto.getUsername(), new Timestamp(System.currentTimeMillis()));
    }
    public UserDto mapUserToUserResponse(User user) {
        return new UserDto(user.getUser_id(), user.getUsername(), user.getCreated_at());
    }
}
