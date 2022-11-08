package com.api.ufood.service;

import com.api.ufood.model.user.User;
import com.api.ufood.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;


    public User signUp(User user) {

        if (userRepository.findByEmail(user.getEmail()) == null) {
            User newUser = new User();

            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            return userRepository.save(newUser);
        }

        throw new RuntimeException("There is already a user with that email: " + user.getEmail());
    }

    public User getUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {
            //return user;
        }

        return new User();

        //return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        Optional<User> oldUser = userRepository.findById(user.getId());
        User updatedUser = null;

        if (oldUser.isPresent()) {
            updatedUser = oldUser.get();

            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setFirstName(user.getLastName());
            updatedUser.setEmail(user.getEmail());

            userRepository.save(updatedUser);
        }

        // Return empty user if there is not a user to update
        else return new User();

        return updatedUser;
    }

    public String deleteUser(int id) {
        if (userRepository.findById(id).isPresent()) userRepository.deleteById(id);

        else return "Unsuccessful Deletion because there is not a user with that id";

        return "Successful Deletion";
    }
}
