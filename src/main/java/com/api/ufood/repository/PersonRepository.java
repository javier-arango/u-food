package com.api.ufood.repository;

import com.api.ufood.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByEmail(String email);
}
