package com.productservicepoc.service;

import com.productservicepoc.dto.UserRequest;
import com.productservicepoc.dto.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<Void> create(UserRequest userRequest);
    UserResponse getById(Integer id);
    List<UserResponse> getAll();
    ResponseEntity<Void> update(UserRequest userRequest);
    ResponseEntity<Void> delete(Integer id);
}
