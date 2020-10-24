package com.productpickerservicepoc.service;

import com.productpickerservicepoc.dto.UserRequest;
import com.productpickerservicepoc.dto.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<Void> create(UserRequest userRequest);
    UserResponse getById(Integer id);
    List<UserResponse> getAll();
    ResponseEntity<Void> update(UserRequest userRequest);
    ResponseEntity<Void> delete(Integer id);
}
