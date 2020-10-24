package com.productpickerservicepoc.validation;

import com.productpickerservicepoc.dto.UserDto;
import com.productpickerservicepoc.mapper.UserMapper;
import com.productpickerservicepoc.repository.UserRepository;
import com.productpickerservicepoc.service.UserService;
import com.productpickerservicepoc.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("userServiceValidator")
public class UserServiceValidator implements UserService {
    private UserRepository userRepository;
    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserServiceValidator(UserRepository userRepository, UserServiceImpl UserServiceImpl) {
        this.userRepository = userRepository;
        this.userServiceImpl = UserServiceImpl;
    }

    @Override
    public ResponseEntity<Void> create(UserDto userDto) {
        return userServiceImpl.create(userDto);
    }

    @Override
    public ResponseEntity<Void> getById(Integer id) {
        return userServiceImpl.getById(id);
    }

    @Override
    public ResponseEntity<Void> getAll() {
        return userServiceImpl.getAll();
    }

    @Override
    // TODO: Validate that the user exists
    public ResponseEntity<Void> update(UserDto userDto) {
        return userServiceImpl.update(userDto);
    }

    @Override
    // TODO: Validate that the user exists
    public ResponseEntity<Void> delete(Integer id) {
        return userServiceImpl.delete(id);
    }
}
