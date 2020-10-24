package com.productpickerservicepoc.service;

import com.productpickerservicepoc.dto.UserDto;
import com.productpickerservicepoc.mapper.UserMapper;
import com.productpickerservicepoc.models.User;
import com.productpickerservicepoc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.CREATED;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = new UserMapper();
    }

    // TODO: If user exists return bad request
    public ResponseEntity<Void> create(UserDto userDto) {
        User user = userMapper.map(userDto);
        LOGGER.info(user.toString());
        userRepository.save(user);
        return new ResponseEntity<>(CREATED);
    }

    public ResponseEntity<Void> getById(Integer id) {
        return new ResponseEntity<>(CREATED);
    }

    public ResponseEntity<Void> getAll() {
        return new ResponseEntity<>(CREATED);
    }

    // TODO: Validate that the user exists
    public ResponseEntity<Void> update(UserDto userDto) {
        return new ResponseEntity<>(CREATED);
    }

    // TODO: Validate that the user exists
    public ResponseEntity<Void> delete(Integer id) {
        return new ResponseEntity<>(CREATED);
    }
}
