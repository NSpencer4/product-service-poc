package com.productpickerservicepoc.service;

import com.productpickerservicepoc.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Void> create(UserDto userDto);
    ResponseEntity<Void> getById(Integer id);
    ResponseEntity<Void> getAll();
    ResponseEntity<Void> update(UserDto userDto);
    ResponseEntity<Void> delete(Integer id);
}
