package com.github.vendigo.examples.acetest.first;

import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<Person, String> {
    Person save(Person person);
}
