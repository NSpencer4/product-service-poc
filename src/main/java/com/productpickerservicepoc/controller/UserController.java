package com.productpickerservicepoc.controller;

import com.productpickerservicepoc.dto.UserDto;
import com.productpickerservicepoc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return userService.create(userDto);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Void> getById(@PathVariable Integer id) {
        LOGGER.info(id.toString());
        return userService.getById(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Void> getAll() {
        return userService.getAll();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody UserDto userDto) {
        LOGGER.info(userDto.toString());
        return userService.update(userDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        LOGGER.info(id.toString());
        return userService.delete(id);
    }
}
