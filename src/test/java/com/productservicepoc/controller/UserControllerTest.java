package com.productservicepoc.controller;

import com.productservicepoc.dto.UserDto;
import com.productservicepoc.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private UserDto mockUserDto;
    private UserDto mockUserDto;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController = new UserController();

    @BeforeEach
    void setUp() {
        this.mockUserDto = new UserDto(1, "Chase", new Timestamp(System.currentTimeMillis()));
        this.mockUserDto = new UserDto(1, "Chase", new Timestamp(System.currentTimeMillis()));
    }

    @Nested
    @DisplayName("Create Method")
    class create {
        @Test
        @DisplayName("Should call the user service create method with the user request and returns the response")
        void callsTheServiceCreateMethod() {
            ResponseEntity<Void> mockResponse = new ResponseEntity<>(HttpStatus.OK);
            Mockito.when(userService.create(mockUserDto)).thenReturn(mockResponse);
            ResponseEntity<Void> result = userController.create(mockUserDto);
            Mockito.verify(userService, atLeastOnce()).create(mockUserDto);
            assert(result).equals(mockResponse);
        }
    }

    @Nested
    @DisplayName("GetById Method")
    class getById {
        @ParameterizedTest
        @ValueSource(ints = { 1, 2, 3, 4, 5 })
        @DisplayName("Should call the user service getById method with the user id and returns the response")
        void callsTheServiceCreateMethod(Integer id) {
            Mockito.when(userService.getById(id)).thenReturn(mockUserDto);
            ResponseEntity<UserDto> result = userController.getById(id);
            Mockito.verify(userService, atLeastOnce()).getById(id);
            assert(result.getStatusCode()).equals(HttpStatus.OK);
            assert Objects.equals(result.getBody(), mockUserDto);
        }
    }

    @Nested
    @DisplayName("GetAll Method")
    class getAll {
        @Test
        @DisplayName("Should call the user service getAll method and returns the user list response")
        void callsTheServiceCreateMethod() {
            List<UserDto> respList = new ArrayList<UserDto>();
            respList.add(mockUserDto);
            Mockito.when(userService.getAll()).thenReturn(respList);
            ResponseEntity<List<UserDto>> result = userController.getAll();
            Mockito.verify(userService, atLeastOnce()).getAll();
            assert(result.getStatusCode()).equals(HttpStatus.OK);
            assert Objects.equals(result.getBody(), respList);
        }
    }

    @Nested
    @DisplayName("Update Method")
    class update {
        @Test
        @DisplayName("Should call the user service update method with the user request and returns the response")
        void callsTheServiceCreateMethod() {
            ResponseEntity<Void> mockResponse = new ResponseEntity<>(HttpStatus.OK);
            Mockito.when(userService.update(mockUserDto)).thenReturn(mockResponse);
            ResponseEntity<Void> result = userController.update(mockUserDto);
            Mockito.verify(userService, atLeastOnce()).update(mockUserDto);
            assert(result).equals(mockResponse);
        }
    }

    @Nested
    @DisplayName("Delete Method")
    class delete {
        @ParameterizedTest
        @ValueSource(ints = { 1, 2, 3, 4, 5 })
        @DisplayName("Should call the user service delete method with the user id and returns an ok response")
        void callsTheServiceCreateMethod(Integer id) {
            ResponseEntity<Void> mockResponse = new ResponseEntity<>(HttpStatus.OK);
            Mockito.when(userService.delete(id)).thenReturn(mockResponse);
            ResponseEntity<Void> result = userController.delete(id);
            Mockito.verify(userService, atLeastOnce()).delete(id);
            assert(result).equals(mockResponse);
        }
    }
}