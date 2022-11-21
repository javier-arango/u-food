package com.api.ufood.service;

import com.api.ufood.model.person.Person;
import com.api.ufood.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class PersonService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PersonRepository personRepository;


    public Person signUp(Person person) {

        if (personRepository.findByEmail(person.getEmail()) == null) {
            Person newPerson = new Person();

            newPerson.setFirstName(person.getFirstName());
            newPerson.setLastName(person.getLastName());
            newPerson.setEmail(person.getEmail());
            newPerson.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));

            return personRepository.save(newPerson);
        }

        throw new RuntimeException("There is already a user with that email: " + person.getEmail());
    }

    public Person getUserByEmail(String email) {
        Optional<Person> user = Optional.ofNullable(personRepository.findByEmail(email));

        if (user.isPresent()) {
            return user.get();
        }

        throw new UsernameNotFoundException("The user doesn't exist");
    }

    public Person updateProfile(Person person) {
        Optional<Person> oldUser = Optional.ofNullable(personRepository.findByEmail(person.getEmail()));

        if (oldUser.isPresent()) {
            Person newPerson = oldUser.get();

            newPerson.setFirstName(person.getFirstName());
            newPerson.setLastName(person.getLastName());

            return personRepository.save(newPerson);
        }

        throw new UsernameNotFoundException("The user doesn't exist");
    }

    public Person changePassword(Person person, String newPassword) {
        Optional<Person> currentUser = Optional.ofNullable(personRepository.findByEmail(person.getEmail()));

        if (currentUser.isPresent()) {
            Person personModel = currentUser.get();

            personModel.setPassword(bCryptPasswordEncoder.encode(newPassword));

            return personRepository.save(personModel);
        }

        throw new UsernameNotFoundException("The user doesn't exist");
    }

    public String deleteUser(String email) {
        Optional<Person> currentUser = Optional.ofNullable(personRepository.findByEmail(email));

        if (currentUser.isPresent()) {
            Person personModel = currentUser.get();

            personRepository.deleteById(personModel.getId());

            return "Successful Deletion";
        }

        throw new UsernameNotFoundException("The user doesn't exist");
    }
}
