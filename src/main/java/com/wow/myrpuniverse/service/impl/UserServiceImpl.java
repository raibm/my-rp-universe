package com.wow.myrpuniverse.service.impl;

import com.wow.myrpuniverse.entity.User;
import com.wow.myrpuniverse.exception.CursedException;
import com.wow.myrpuniverse.repository.UserRepository;
import com.wow.myrpuniverse.service.UserService;
import com.wow.myrpuniverse.service.dto.UserDto;
import com.wow.myrpuniverse.service.mapper.UserMapper;

import javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElse(new User());
        return userMapper.toDto(user);
    }
}
