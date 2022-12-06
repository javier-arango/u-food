package com.api.ufood.controller.api;

import com.api.ufood.controller.request.UserSignupRequest;
import com.api.ufood.dto.model.user.UserDto;
import com.api.ufood.dto.response.Response;
import com.api.ufood.service.UserAuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


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
    public Response signup(@RequestBody @Valid UserSignupRequest userSignupRequest) {
        UserDto userDto = new UserDto()
                .setEmail(userSignupRequest.getEmail())
                .setPassword(userSignupRequest.getPassword())
                .setFirstName(userSignupRequest.getFirstName())
                .setLastName(userSignupRequest.getLastName())
                .setAdmin(false);

        return Response.ok().setPayload(userAuthService.signup(userDto));
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
