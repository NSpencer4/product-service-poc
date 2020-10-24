package com.productpickerservicepoc.controller;

import com.productpickerservicepoc.dto.UserDto;
import com.productpickerservicepoc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody UserDto userDto) {
        LOGGER.info(userDto.toString());
        userService.create(userDto);
        return new ResponseEntity<>(CREATED);
    }
}
