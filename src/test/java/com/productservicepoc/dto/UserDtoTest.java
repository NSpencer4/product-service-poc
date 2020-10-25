package com.productservicepoc.dto;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

class UserDtoTest {
    Timestamp testTimestamp = new Timestamp(System.currentTimeMillis());
    private UserDto userDto = new UserDto(1, "chase", testTimestamp);

    @Test
    void getId() {
        assert userDto.getId().equals(1);
    }

    @Test
    void setId() {
        userDto.setId(2);
        assert userDto.getId().equals(2);
    }

    @Test
    void getUsername() {
        assert userDto.getUsername().equals("chase");
    }

    @Test
    void setUsername() {
        userDto.setUsername("test");
        assert userDto.getUsername().equals("test");
    }

    @Test
    void getCreatedAt() {
        assert userDto.getCreatedAt().equals(testTimestamp);
    }

    @Test
    void setCreatedAt() {
        Timestamp testStamp = new Timestamp(System.currentTimeMillis());
        userDto.setCreatedAt(testStamp);
        assert userDto.getCreatedAt().equals(testStamp);
    }

    @Test
    void testToString() {
        userDto = new UserDto(1, "chase", testTimestamp);
        String expectedToString = "UserDto{" +
                "id=" + 1 +
                ", username='" + "chase" + '\'' +
                ", createdAt=" + testTimestamp +
                '}';
        String result = userDto.toString();
        assert result.equals(expectedToString);
    }
}