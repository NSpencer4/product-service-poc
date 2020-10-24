package com.productpickerservicepoc.service;

import com.productpickerservicepoc.dto.UserDto;
import com.productpickerservicepoc.mapper.UserMapper;
import com.productpickerservicepoc.models.User;
import com.productpickerservicepoc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper = new UserMapper();

    public void create(UserDto userDto) {
        User user = userMapper.map(userDto);
        LOGGER.info(user.toString());
        userRepository.save(user);
    }
}
