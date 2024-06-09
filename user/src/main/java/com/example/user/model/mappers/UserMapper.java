package com.example.user.model.mappers;

import com.example.user.model.dtos.UserCreateDto;
import com.example.user.model.dtos.UserDto;
import com.example.user.model.dtos.UserUpdateDto;
import com.example.user.model.entities.User;
import com.example.user.model.mappers.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDto, UserCreateDto, UserUpdateDto> {
}
