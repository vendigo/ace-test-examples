package com.github.vendigo.examples.acetest.second;

import org.springframework.data.repository.Repository;

public interface CountryRepository extends Repository<Country, String> {
    Country save(Country person);
}
