package com.productservicepoc.mapper;

import com.productservicepoc.dto.UserDto;
import com.productservicepoc.models.User;

public class UserMapper {
    public User mapUserDtoToUser(UserDto UserDto) {
        return new User(UserDto.getId(), UserDto.getUsername(), UserDto.getCreatedAt());
    }
    public UserDto mapUserToUserDto(User user) {
        return new UserDto(user.getUser_id(), user.getUsername(), user.getCreated_at());
    }
}
