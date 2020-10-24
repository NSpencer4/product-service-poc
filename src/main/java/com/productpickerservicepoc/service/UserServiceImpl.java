package com.productpickerservicepoc.service;

import com.productpickerservicepoc.constants.Constants;
import com.productpickerservicepoc.dto.UserRequest;
import com.productpickerservicepoc.dto.UserResponse;
import com.productpickerservicepoc.exception.NotFoundException;
import com.productpickerservicepoc.mapper.UserMapper;
import com.productpickerservicepoc.models.User;
import com.productpickerservicepoc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;
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
    @Transactional()
    public ResponseEntity<Void> create(UserRequest userRequest) {
        User user = userMapper.map(userRequest);
        LOGGER.info(user.toString());
        userRepository.save(user);
        return new ResponseEntity<>(CREATED);
    }

    @Transactional(readOnly = true)
    public UserResponse getById(Integer id) {
        LOGGER.info(id.toString());
        return userMapper.mapToUserResponse(userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.USER_NOT_FOUND_ERROR_CODE, Constants.USER_NOT_FOUND_ERROR_MESSAGE)));
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapToUserResponse)
                .collect(toList());
    }

    // TODO: Validate that the user exists
    @Transactional()
    public ResponseEntity<Void> update(UserRequest userRequest) {
        return new ResponseEntity<>(CREATED);
    }

    // TODO: Validate that the user exists
    @Transactional()
    public ResponseEntity<Void> delete(Integer id) {
        return new ResponseEntity<>(CREATED);
    }
}
