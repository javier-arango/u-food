package com.api.ufood.service;

import com.api.ufood.dto.mapper.UserMapper;
import com.api.ufood.dto.model.user.UserDto;
import com.api.ufood.model.user.Role;
import com.api.ufood.model.user.User;
import com.api.ufood.model.user.UserRoles;
import com.api.ufood.repository.RoleRepository;
import com.api.ufood.repository.UserRepository;

import com.api.ufood.security.email.EmailSenderService;
import com.api.ufood.security.token.ConfirmationToken;
import com.api.ufood.security.token.ConfirmationTokenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService  {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Value("${ufood-security.token-expiration-time}")
    private int tokenExpirationTime;


    public UserDto signup(UserDto userDto) throws RuntimeException {

        Role userRole;
        User user = userRepository.findByEmail(userDto.getEmail());

        if (user == null) {
            // Check and set user roles
            if (userDto.isAdmin()) userRole = roleRepository.findByRole(UserRoles.ADMIN);
            else userRole = roleRepository.findByRole(UserRoles.USER);

            user = new User()
                    .setFirstName(userDto.getFirstName())
                    .setLastName(userDto.getLastName())
                    .setEmail(userDto.getEmail())
                    .setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()))
                    .setRoles(new HashSet<>(Arrays.asList(userRole)));

            // Save user in the database
            UserDto savedUser = UserMapper.toUserDto(userRepository.save(user));

            // Create token for confirmation
            String token = generateToken(user);

            // Send confirmation email
            String link = "http://localhost:8080/api/v1/user/signup/confirmation?confirmation_token=" + token;
            emailSenderService.send(userDto.getEmail(), userDto.getFirstName(), link);

            return savedUser;
        }

        throw new RuntimeException("There is already a user with that email: " + userDto.getEmail());
    }

    public UserDto findUserByEmail(String email) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));

        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
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

    @Transactional
    public String confirmEmail(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("Token not found"));

        if (confirmationToken.getConfirmedAt() != null) throw new IllegalStateException("Email already confirmed");

        // Expiration time
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) throw new IllegalStateException("Token expired");

        confirmationTokenService.setConfirmedAt(token);

        userRepository.enableUser(confirmationToken.getUser().getEmail());

        return "Your Email is Confirmed!";
    }

    private String generateToken(User user) {
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(tokenExpirationTime),
                user
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

        return token;
    }
}
