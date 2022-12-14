package com.api.ufood.dto.mapper;

import com.api.ufood.dto.model.user.RoleDto;
import com.api.ufood.dto.model.user.UserDto;

import com.api.ufood.model.user.UserEntity;
import org.modelmapper.ModelMapper;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public static UserDto toUserDto(UserEntity user) {
        return new UserDto()
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .setEnabled(user.getIsEnabled())
                .setRoles(new HashSet<RoleDto>(user
                        .getRoles()
                        .stream()
                        .map(role -> new ModelMapper().map(role, RoleDto.class))
                        .collect(Collectors.toSet())));
    }

}