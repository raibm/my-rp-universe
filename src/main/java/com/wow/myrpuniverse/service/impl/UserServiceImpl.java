package com.wow.myrpuniverse.service.impl;

import com.wow.myrpuniverse.repository.UserRepository;
import com.wow.myrpuniverse.service.UserService;
import com.wow.myrpuniverse.service.dto.UserDto;
import com.wow.myrpuniverse.service.mapper.UserMapper;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto findById(Long id){
//        User user = userRepository.findById(id).orElseThrow(
//                () -> new BusinessException(HttpStatus.NOT_FOUND, "User not found.")
//        );
//        return userMapper.toDto(user);
        return null;
    }
}
