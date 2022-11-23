package com.api.ufood.controller.api;

import com.api.ufood.controller.request.UserPasswordRequest;
import com.api.ufood.controller.request.UserProfileFormRequest;
import com.api.ufood.controller.request.UserSignupRequest;
import com.api.ufood.dto.model.user.UserDto;
import com.api.ufood.dto.response.Response;
import com.api.ufood.model.restaurant.Restaurant;
import com.api.ufood.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
@Api(description = "Operations pertaining to user management in the UFood application")
public class UserController {
    @Autowired
    private UserService userService;


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

        return Response.ok().setPayload(userService.signup(userDto));
    }

    @GetMapping("{email}")
    @ApiOperation(
            value= "Find a user by email",
            notes = "Provide an email to look up specific user from the database",
            response = UserDto.class
    )
    public UserDto getUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @PutMapping("updateProfile")
    @ApiOperation(
            value= "Update user first name and last name",
            notes = "Provide an email to look up specific user from the database " +
                    "and update the user with the new data",
            response = Restaurant.class
    )
    public Response updateProfile(@RequestBody UserProfileFormRequest userProfileFormRequest) {

        UserDto userDto = userService.findUserByEmail(userProfileFormRequest.getEmail());

        if (userDto != null) {
            userDto.setFirstName(userProfileFormRequest.getFirstName());
            userDto.setLastName(userProfileFormRequest.getLastName());

            return Response.ok().setPayload(userService.updateProfile(userDto));
        }

        return Response.notFound();
    }

    @PutMapping("changePassword")
    @ApiOperation(
            value= "Change user current password to a new one",
            notes = "Provide an email to look up specific user from the database " +
                    "and change the password",
            response = Response.class
    )
    public Response changePassword(@RequestBody UserPasswordRequest userPasswordRequest) {
        UserDto userDto = userService.findUserByEmail(userPasswordRequest.getEmail());

        if (userDto != null) {
            return Response.ok().setPayload(userService.changePassword(
                    userDto,
                    userPasswordRequest.getNewPassword()
            ));
        }

        return Response.notFound();
    }

    @DeleteMapping("deleteAccount/{email}")
    @ApiOperation(
            value= "Delete current user from the database",
            notes = "Provide an email to look up specific user from the database " +
                    "and delete it from database",
            response = String.class
    )
    public String deleteUser(@PathVariable String email) {
        return userService.deleteUser(email);
    }

}
