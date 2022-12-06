package com.api.ufood.controller.api;

import com.api.ufood.controller.request.UserLoginRequest;
import com.api.ufood.controller.request.UserSignupRequest;
import com.api.ufood.dto.model.user.UserDto;
import com.api.ufood.dto.response.AuthResponse;
import com.api.ufood.dto.response.Response;
import com.api.ufood.service.UserAuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/auth")
@Api(description = "Operations pertaining to user authentication in the UFood application")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;


    @PostMapping("signup")
    @ApiOperation(
            value= "Add a new user to the database",
            notes = "Provide the person data to create a new user in the database",
            response = Response.class
    )
    public ResponseEntity<String> signup(@RequestBody @Valid UserSignupRequest userSignupRequest) {
        UserDto userDto = new UserDto()
                .setEmail(userSignupRequest.getEmail())
                .setPassword(userSignupRequest.getPassword())
                .setFirstName(userSignupRequest.getFirstName())
                .setLastName(userSignupRequest.getLastName())
                .setAdmin(false);

        // Signup the user
        return userAuthService.signup(userDto);
    }

    @PostMapping("login")
    @ApiOperation(
            value= "Login the user into the API",
            notes = "Provide the email and password user at signup, so it let you login",
            response = Response.class
    )
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        // Login the user
        return userAuthService.login(userLoginRequest);
    }

    @GetMapping("/confirmation")
    @ApiOperation(
            value= "Confirm user email using a unique token",
            notes = "Provide a confirmation token, so the email can be confirm in the database",
            response = String.class
    )
    public String confirmEmail(@RequestParam("confirmation_token") String token) {
        return userAuthService.confirmEmail(token);
    }
}
