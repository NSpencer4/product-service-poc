package com.productpickerservicepoc.controller;

import com.productpickerservicepoc.dto.UserRequest;
import com.productpickerservicepoc.dto.UserResponse;
import com.productpickerservicepoc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody UserRequest userRequest) {
        LOGGER.info(userRequest.toString());
        userService.create(userRequest);
        return userService.create(userRequest);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Integer id) {
        LOGGER.info(id.toString());
        return status(OK).body(userService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> getAll() {
        return status(OK).body(userService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody UserRequest userRequest) {
        LOGGER.info(userRequest.toString());
        return userService.update(userRequest);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        LOGGER.info(id.toString());
        userService.delete(id);
        return new ResponseEntity<Void>(OK);
    }
}
