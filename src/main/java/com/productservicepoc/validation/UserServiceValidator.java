package com.productservicepoc.validation;

import com.productservicepoc.constants.Constants;
import com.productservicepoc.dto.UserDto;
import com.productservicepoc.exception.NotFoundException;
import com.productservicepoc.exception.UserExistsException;
import com.productservicepoc.repository.UserRepository;
import com.productservicepoc.service.UserService;
import com.productservicepoc.service.UserServiceImpl;
import com.productservicepoc.util.ValidationUtil;
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
    public ResponseEntity<Void> create(UserDto UserDto) {
        ValidationUtil.ensureRequestDataIsNotNull(UserDto);
        if (!userRepository.existsById(UserDto.getId())) {
            return userServiceImpl.create(UserDto);
        } else {
            throw new UserExistsException(Constants.USER_EXISTS_ERROR_MESSAGE);
        }
    }

    @Override
    public UserDto getById(Integer id) {
        ValidationUtil.ensureRequestDataIsNotNull(id);
        return userServiceImpl.getById(id);
    }

    @Override
    public List<UserDto> getAll() {
        return userServiceImpl.getAll();
    }

    @Override
    public ResponseEntity<Void> update(UserDto UserDto) {
        ValidationUtil.ensureRequestDataIsNotNull(UserDto);
        ValidationUtil.ensureRequestDataIsNotNull(UserDto.getId());
        if (userRepository.existsById(UserDto.getId())) {
            return userServiceImpl.update(UserDto);
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
