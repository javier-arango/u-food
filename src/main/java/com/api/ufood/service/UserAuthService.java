package com.api.ufood.service;

import com.api.ufood.controller.request.UserLoginRequest;
import com.api.ufood.dto.mapper.UserMapper;
import com.api.ufood.dto.model.user.UserDto;
import com.api.ufood.dto.response.AuthResponse;
import com.api.ufood.model.user.Role;
import com.api.ufood.model.user.UserEntity;
import com.api.ufood.model.user.UserRoles;
import com.api.ufood.repository.RoleRepository;
import com.api.ufood.repository.UserRepository;

import com.api.ufood.security.email.EmailSenderService;
import com.api.ufood.security.filter.JWTGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.api.ufood.security.token.ConfirmationToken;
import com.api.ufood.security.token.ConfirmationTokenService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

@Service
public class UserAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private JWTGenerator jwtGenerator;

    @Value("${ufood-security.token-expiration-time}")
    private int tokenExpirationTime;


    public ResponseEntity<String> signup(UserDto userDto) throws RuntimeException {

        Role userRole;
        UserEntity user = userRepository.findByEmail(userDto.getEmail());

        if (user == null) {
            // Check and set user roles
            if (userDto.isAdmin()) userRole = roleRepository.findByRole(UserRoles.ADMIN);
            else userRole = roleRepository.findByRole(UserRoles.USER);

            user = new UserEntity()
                    .setFirstName(userDto.getFirstName())
                    .setLastName(userDto.getLastName())
                    .setEmail(userDto.getEmail())
                    .setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()))
                    .setRoles(new HashSet<>(Collections.singletonList(userRole)));

            // Save user in the database
            UserMapper.toUserDto(userRepository.save(user));

            // Create token for confirmation
            String token = generateToken(user);

            // Send confirmation email
            String link = "http://localhost:8080/api/v1/user/auth/confirmation?confirmation_token=" + token;
            emailSenderService.send(userDto.getEmail(), userDto.getFirstName(), link);

            return new ResponseEntity<>("User registered success!", HttpStatus.OK);
        }

        return new ResponseEntity<>("The email is already taken!", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<AuthResponse> login(UserLoginRequest userLoginRequest) throws RuntimeException {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginRequest.getEmail(),
                        userLoginRequest.getPassword()
        ));

        // Keep the user login without the need to add their info again
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Get token
        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(new AuthResponse(token), HttpStatus.OK);
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

    private String generateToken(UserEntity user) {
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
