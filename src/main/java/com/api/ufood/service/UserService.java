package com.api.ufood.service;

import com.api.ufood.dto.mapper.UserMapper;
import com.api.ufood.dto.model.user.UserDto;
import com.api.ufood.model.user.User;
import com.api.ufood.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserService  {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;


    public UserDto findUserByEmail(String email) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));

        if (user.isPresent()) {
            return UserMapper.toUserDto(user.get());
        }

        throw  new UsernameNotFoundException(String.format("User with email %s not found", email));
    }

    public UserDto updateProfile(UserDto userDto) throws UsernameNotFoundException {
        Optional<User> oldUser = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));

        if (oldUser.isPresent()) {
            User newUser = oldUser.get();

            newUser.setFirstName(userDto.getFirstName());
            newUser.setLastName(userDto.getLastName());

            return UserMapper.toUserDto(userRepository.save(newUser));
        }

        throw new UsernameNotFoundException(String.format("User with email %s not found", userDto.getEmail()));
    }

    public UserDto changePassword(UserDto userDto, String newPassword) throws UsernameNotFoundException{
        Optional<User> currentUser = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));

        if (currentUser.isPresent()) {
            User userModel = currentUser.get();

            userModel.setPassword(bCryptPasswordEncoder.encode(newPassword));

            return UserMapper.toUserDto(userRepository.save(userModel));
        }

        throw new UsernameNotFoundException(String.format("User with email %s not found", userDto.getEmail()));
    }

    public String deleteUser(String email) throws UsernameNotFoundException {
        Optional<User> currentUser = Optional.ofNullable(userRepository.findByEmail(email));

        if (currentUser.isPresent()) {
            User userModel = currentUser.get();

            userRepository.deleteById(userModel.getId());

            return "Successful Deletion";
        }

        throw new UsernameNotFoundException(String.format("User with email %s not found", email));
    }
}
