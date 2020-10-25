package com.productservicepoc.models;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

class UserTest {
    Timestamp testTimestamp = new Timestamp(System.currentTimeMillis());
    private User user = new User(1, "chase", testTimestamp);

    @Test
    void getUser_id() {
        assert user.getUser_id().equals(1);
    }

    @Test
    void setUser_id() {
        user.setUser_id(2);
        assert user.getUser_id().equals(2);
    }

    @Test
    void getUsername() {
        assert user.getUsername().equals("chase");
    }

    @Test
    void setUsername() {
        user.setUsername("test");
        assert user.getUsername().equals("test");
    }

    @Test
    void getCreated_at() {
        assert user.getCreated_at().equals(testTimestamp);
    }

    @Test
    void setCreated_at() {
        Timestamp testStamp = new Timestamp(System.currentTimeMillis());
        user.setCreated_at(testStamp);
        assert user.getCreated_at().equals(testStamp);
    }

    @Test
    void testToString() {
        user = new User(1, "chase", testTimestamp);
        String expectedToString = "User{" +
                "user_id=" + 1 +
                ", username='" + "chase" + '\'' +
                ", created_at=" + testTimestamp +
                '}';
        String result = user.toString();
        assert result.equals(expectedToString);
    }
}