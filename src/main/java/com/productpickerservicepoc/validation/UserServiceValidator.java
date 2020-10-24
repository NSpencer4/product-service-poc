package com.productpickerservicepoc.validation;

import com.productpickerservicepoc.dto.UserRequest;
import com.productpickerservicepoc.dto.UserResponse;
import com.productpickerservicepoc.repository.UserRepository;
import com.productpickerservicepoc.service.UserService;
import com.productpickerservicepoc.service.UserServiceImpl;
import com.productpickerservicepoc.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public ResponseEntity<Void> create(UserRequest userRequest) {
        ValidationUtil.ensureRequestDataIsNotNull(userRequest);
        return userServiceImpl.create(userRequest);
    }

    @Override
    public UserResponse getById(Integer id) {
        ValidationUtil.ensureRequestDataIsNotNull(id);
        return userServiceImpl.getById(id);
    }

    @Override
    public List<UserResponse> getAll() {
        return userServiceImpl.getAll();
    }

    @Override
    // TODO: Validate that the user exists
    public ResponseEntity<Void> update(UserRequest userRequest) {
        ValidationUtil.ensureRequestDataIsNotNull(userRequest);
        return userServiceImpl.update(userRequest);
    }

    @Override
    // TODO: Validate that the user exists
    public ResponseEntity<Void> delete(Integer id) {
        ValidationUtil.ensureRequestDataIsNotNull(id);
        return userServiceImpl.delete(id);
    }
}
