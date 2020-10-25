package com.productservicepoc.service;

import com.productservicepoc.constants.Constants;
import com.productservicepoc.dto.UserRequest;
import com.productservicepoc.dto.UserResponse;
import com.productservicepoc.exception.NotFoundException;
import com.productservicepoc.mapper.UserMapper;
import com.productservicepoc.models.User;
import com.productservicepoc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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

    @Transactional()
    public ResponseEntity<Void> create(UserRequest userRequest) {
        User user = userMapper.mapUserRequestToUser(userRequest);
        LOGGER.info(user.toString());
        userRepository.save(user);
        return new ResponseEntity<>(CREATED);
    }

    @Transactional(readOnly = true)
    public UserResponse getById(Integer id) {
        LOGGER.info(id.toString());
        return userMapper.mapUserToUserResponse(userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.USER_NOT_FOUND_ERROR_MESSAGE)));
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapUserToUserResponse)
                .collect(toList());
    }

    @Transactional()
    public ResponseEntity<Void> update(UserRequest userRequest) {
        User user = userMapper.mapUserRequestToUser(userRequest);
        userRepository.save(user);
        return new ResponseEntity<>(OK);
    }

    @Transactional()
    public ResponseEntity<Void> delete(Integer id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(OK);
    }
}
