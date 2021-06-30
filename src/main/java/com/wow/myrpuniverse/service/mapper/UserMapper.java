package com.wow.myrpuniverse.service.mapper;

import com.wow.myrpuniverse.entity.User;
import com.wow.myrpuniverse.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User entity);

    List<User> toEntity(List<UserDto> dtoList);

    List <UserDto> toDto(List<User> entityList);

}
