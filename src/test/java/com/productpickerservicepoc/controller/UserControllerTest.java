package com.productpickerservicepoc.controller;

import com.productpickerservicepoc.dto.UserRequest;
import com.productpickerservicepoc.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;

import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private UserRequest mockUserRequest;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController = new UserController();

    @BeforeEach
    void setUp() {
        this.mockUserRequest = new UserRequest(1, "Chase", new Timestamp(System.currentTimeMillis()));
    }

    @Nested
    @DisplayName("Create Method")
    class create {
        @Test
        @DisplayName("Should call the user service create method with the user request and returns the response")
        void callsTheServiceCreateMethod() {
            ResponseEntity<Void> mockResponse = new ResponseEntity<>(HttpStatus.OK);
            Mockito.when(userService.create(mockUserRequest)).thenReturn(mockResponse);
            ResponseEntity<Void> result = userController.create(mockUserRequest);
            Mockito.verify(userService, atLeastOnce()).create(mockUserRequest);
            assert(result).equals(mockResponse);
        }
    }

    @Nested
    @DisplayName("GetById Method")
    class getById {
    }

    @Nested
    @DisplayName("GetAll Method")
    class getAll {
    }

    @Nested
    @DisplayName("Update Method")
    class update {
    }

    @Nested
    @DisplayName("Delete Method")
    class delete {
    }
}