package com.api.ufood.service;

import com.api.ufood.dto.mapper.UserMapper;
import com.api.ufood.dto.model.user.UserDto;
import com.api.ufood.model.user.Role;
import com.api.ufood.model.user.User;
import com.api.ufood.model.user.UserRoles;
import com.api.ufood.repository.RoleRepository;
import com.api.ufood.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserService  {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;


    public UserDto signup(UserDto userDto) throws RuntimeException {

        Role userRole;
        User user = userRepository.findByEmail(userDto.getEmail());

        if (user == null) {
            if (userDto.isAdmin()) {
                userRole = roleRepository.findByRole(UserRoles.ADMIN);
            } else {
                userRole = roleRepository.findByRole(UserRoles.USER);
            }

            user = new User()
                    .setFirstName(userDto.getFirstName())
                    .setLastName(userDto.getLastName())
                    .setEmail(userDto.getEmail())
                    .setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()))
                    .setRoles(new HashSet<>(Arrays.asList(userRole)));

            return UserMapper.toUserDto(userRepository.save(user));
        }

        throw new RuntimeException("There is already a user with that email: " + userDto.getEmail());
    }

    public UserDto findUserByEmail(String email) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));

        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }

        throw  new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
    }

    public UserDto updateProfile(UserDto userDto) throws UsernameNotFoundException {
        Optional<User> oldUser = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));

        if (oldUser.isPresent()) {
            User newUser = oldUser.get();

            newUser.setFirstName(userDto.getFirstName());
            newUser.setLastName(userDto.getLastName());

            return UserMapper.toUserDto(userRepository.save(newUser));
        }

        throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, userDto.getEmail()));
    }

    public UserDto changePassword(UserDto userDto, String newPassword) throws UsernameNotFoundException{
        Optional<User> currentUser = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));

        if (currentUser.isPresent()) {
            User userModel = currentUser.get();

            userModel.setPassword(bCryptPasswordEncoder.encode(newPassword));

            return UserMapper.toUserDto(userRepository.save(userModel));
        }

        throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, userDto.getEmail()));
    }

    public String deleteUser(String email) throws UsernameNotFoundException {
        Optional<User> currentUser = Optional.ofNullable(userRepository.findByEmail(email));

        if (currentUser.isPresent()) {
            User userModel = currentUser.get();

            userRepository.deleteById(userModel.getId());

            return "Successful Deletion";
        }

        throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
    }
}
