package com.productservicepoc.service;

import com.productservicepoc.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<Void> create(UserDto UserDto);
    UserDto getById(Integer id);
    List<UserDto> getAll();
    ResponseEntity<Void> update(UserDto UserDto);
    ResponseEntity<Void> delete(Integer id);
}
