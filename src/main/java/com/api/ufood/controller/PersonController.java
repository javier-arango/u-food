package com.api.ufood.controller;

import com.api.ufood.model.person.Person;
import com.api.ufood.service.PersonService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/users")
public class PersonController {
    @Autowired
    private PersonService personService;


    @PostMapping("signUp")
    public Person signup(@RequestBody Person person) {
        return personService.signUp(person);
    }

    @GetMapping("{email}")
    public Person getUserByEmail(@PathVariable String email) {
        return personService.getUserByEmail(email);
    }

    @PutMapping("updateProfile")
    public Person updateProfile(@RequestBody Person person) {
        return personService.updateProfile(person);
    }

    @PutMapping("changePassword")
    public Person changePassword(@RequestBody Person person, String newPassword) {
        return personService.changePassword(person, newPassword);
    }

    @DeleteMapping("deleteAccount/{email}")
    public String deleteUser(@PathVariable String email) {
        return personService.deleteUser(email);
    }
}
