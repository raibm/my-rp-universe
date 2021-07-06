package com.wow.myrpuniverse.service.impl;

import com.wow.myrpuniverse.entity.User;
import com.wow.myrpuniverse.exception.CursedException;
import com.wow.myrpuniverse.repository.UserRepository;
import com.wow.myrpuniverse.service.UserService;
import com.wow.myrpuniverse.service.dto.UserDto;
import com.wow.myrpuniverse.service.mapper.UserMapper;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto findById(Long id) throws CursedException, NotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("notfound"));
        return userMapper.toDto(user);
    }
}
