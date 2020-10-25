package com.productservicepoc.mapper;

import com.productservicepoc.dto.UserDto;
import com.productservicepoc.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {
    private User mockUser;
    private UserDto mockUserDto;

    private UserMapper mapper = new UserMapper();

    @BeforeEach
    void resetData() {
        mockUser = new User(1, "Chase", new Timestamp(23213));
        mockUserDto = new UserDto(1, "Chase", new Timestamp(23213));
    }

    @Test
    @DisplayName("Should take a UserDto object and map it to a User object")
    void mapUserDtoToUser() {
        User result = mapper.mapUserDtoToUser(mockUserDto);
        assertEquals(result.getUser_id(), mockUserDto.getId());
        assertEquals(result.getUsername(), mockUserDto.getUsername());
        assertEquals(result.getCreated_at(), mockUserDto.getCreatedAt());
    }

    @Test
    @DisplayName("Should take a User object and map it to a UserDto object")
    void mapUserToUserDto() {
        UserDto result = mapper.mapUserToUserDto(mockUser);
        assertEquals(result.getId(), mockUser.getUser_id());
        assertEquals(result.getUsername(), mockUser.getUsername());
        assertEquals(result.getCreatedAt(), mockUser.getCreated_at());
    }
}