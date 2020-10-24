package com.productpickerservicepoc.validation;

import com.productpickerservicepoc.constants.Constants;
import com.productpickerservicepoc.dto.UserRequest;
import com.productpickerservicepoc.dto.UserResponse;
import com.productpickerservicepoc.exception.NotFoundException;
import com.productpickerservicepoc.exception.UserExistsException;
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
        if (!userRepository.existsById(userRequest.getId())) {
            return userServiceImpl.create(userRequest);
        } else {
            throw new UserExistsException(Constants.USER_EXISTS_ERROR_MESSAGE);
        }
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
    public ResponseEntity<Void> update(UserRequest userRequest) {
        ValidationUtil.ensureRequestDataIsNotNull(userRequest);
        ValidationUtil.ensureRequestDataIsNotNull(userRequest.getId());
        if (userRepository.existsById(userRequest.getId())) {
            return userServiceImpl.update(userRequest);
        } else {
            throw new NotFoundException(Constants.USER_NOT_FOUND_ERROR_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        ValidationUtil.ensureRequestDataIsNotNull(id);
        if (userRepository.existsById(id)) {
            return userServiceImpl.delete(id);
        } else {
            throw new NotFoundException(Constants.USER_NOT_FOUND_ERROR_MESSAGE);
        }
    }
}
