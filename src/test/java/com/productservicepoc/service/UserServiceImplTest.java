package com.productservicepoc.service;

import com.productservicepoc.dto.UserDto;
import com.productservicepoc.exception.NotFoundException;
import com.productservicepoc.mapper.UserMapper;
import com.productservicepoc.models.User;
import com.productservicepoc.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    private UserDto mockUserDto = new UserDto(1, "test", new Timestamp(22323));
    private User mockUser = new User(1, "test", new Timestamp(22323));
    private List<UserDto> userDtoList;
    private List<User> userList;

    @BeforeEach
    public void init() {
        userDtoList = new ArrayList<UserDto>();
        userDtoList.add(mockUserDto);
        userList = new ArrayList<User>();
        userList.add(mockUser);
    }

    @InjectMocks
    private UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository);

    @Nested
    @DisplayName("Constructor")
    class construct {
        @Test
        @DisplayName("Should instantiate the user service impl")
        void initUserServiceImp() {
            assertNotNull(userServiceImpl);
        }
        @Test
        @DisplayName("Should instantiate the user repository")
        void initUserRepo() {
            assertNotNull(userRepository);
        }
        @Test
        @DisplayName("Should instantiate the user mapper")
        void initUserMapper() {
            assertNotNull(userMapper);
        }
    }

    @Nested
    class create {
        @Test
        @DisplayName("Should take a userDto and call the userMapper to get a User obj")
        void callMapper() {
            Mockito.when(userMapper.mapUserDtoToUser(mockUserDto)).thenReturn(mockUser);
            userServiceImpl.create(mockUserDto);
            Mockito.verify(userMapper, atLeastOnce()).mapUserDtoToUser(mockUserDto);
        }
        @Test
        @DisplayName("Should take the mapped user obj and call the repo to create the user")
        void createUserRepoCall() {
            Mockito.when(userMapper.mapUserDtoToUser(mockUserDto)).thenReturn(mockUser);
            userServiceImpl.create(mockUserDto);
            Mockito.verify(userRepository, atLeastOnce()).save(mockUser);
        }
        @Test
        @DisplayName("Should return a 201")
        void returns201() {
            Mockito.when(userMapper.mapUserDtoToUser(mockUserDto)).thenReturn(mockUser);
            ResponseEntity<Void> resp = userServiceImpl.create(mockUserDto);
            assertEquals(resp, new ResponseEntity<Void>(HttpStatus.CREATED));
        }
    }

    @Nested
    class getById {
        @Test
        @DisplayName("Should take a userDto and call the userMapper to get a User obj")
        void callMapper() {
            Mockito.when(userMapper.mapUserToUserDto(mockUser)).thenReturn(mockUserDto);
            Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));
            userServiceImpl.getById(1);
            Mockito.verify(userMapper, atLeastOnce()).mapUserToUserDto(mockUser);
        }
        @Test
        @DisplayName("Should take the id and call the repo findbyid to get the user")
        void repoFindCall() {
            Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));
            Mockito.when(userMapper.mapUserToUserDto(mockUser)).thenReturn(mockUserDto);
            userServiceImpl.getById(1);
            Mockito.verify(userRepository, atLeastOnce()).findById(1);
        }
        @Test
        @DisplayName("Should return a UserDto")
        void returns200() {
            Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));
            Mockito.when(userMapper.mapUserToUserDto(mockUser)).thenReturn(mockUserDto);
            UserDto resp = userServiceImpl.getById(1);
            assertEquals(resp, mockUserDto);
        }
        @Test
        @DisplayName("Should throw an error if there is no user")
        void throwNoUser() {
            Mockito.when(userRepository.findById(1)).thenReturn(Optional.empty());
            assertThrows(NotFoundException.class, () -> {
                userServiceImpl.getById(1);
            });
        }
    }

    @Nested
    class getAll {
        @Test
        @DisplayName("Should call the user mapper to map the user to the dto")
        void callMapper() {
            Mockito.when(userMapper.mapUserToUserDto(mockUser)).thenReturn(mockUserDto);
            Mockito.when(userRepository.findAll()).thenReturn(userList);
            userServiceImpl.getAll();
            Mockito.verify(userMapper, atLeastOnce()).mapUserToUserDto(mockUser);
        }
        @Test
        @DisplayName("Should call the user repo to get all users")
        void callUserRepoForAllUsers() {
            Mockito.when(userMapper.mapUserToUserDto(mockUser)).thenReturn(mockUserDto);
            Mockito.when(userRepository.findAll()).thenReturn(userList);
            List<UserDto> result = userServiceImpl.getAll();
            Mockito.verify(userRepository, atLeastOnce()).findAll();
            assertEquals(result, userDtoList);
        }
    }

    @Nested
    class update {
        @Test
        @DisplayName("Should call the user mapper to map the dto to the user")
        void callMapper() {
            Mockito.when(userMapper.mapUserDtoToUser(mockUserDto)).thenReturn(mockUser);
            userServiceImpl.update(mockUserDto);
            Mockito.verify(userMapper, atLeastOnce()).mapUserDtoToUser(mockUserDto);
        }
        @Test
        @DisplayName("Should call the user repo save method to update the user record")
        void updateUser() {
            Mockito.when(userMapper.mapUserDtoToUser(mockUserDto)).thenReturn(mockUser);
            userServiceImpl.update(mockUserDto);
            Mockito.verify(userRepository, atLeastOnce()).save(mockUser);
        }
        @Test
        @DisplayName("Should send back a 200")
        void send200() {
            Mockito.when(userMapper.mapUserDtoToUser(mockUserDto)).thenReturn(mockUser);
            ResponseEntity<Void> result = userServiceImpl.update(mockUserDto);
            assertEquals(result.getStatusCode(), HttpStatus.OK);
        }
    }

    @Nested
    class delete {
        @Test
        @DisplayName("Should call the user repo delete method to delete the user record")
        void updateUser() {
            userServiceImpl.delete(1);
            Mockito.verify(userRepository, atLeastOnce()).deleteById(1);
        }
        @Test
        @DisplayName("Should send back a 200")
        void send200() {
            ResponseEntity<Void> result = userServiceImpl.delete(1);
            assertEquals(result.getStatusCode(), HttpStatus.OK);
        }
    }
}