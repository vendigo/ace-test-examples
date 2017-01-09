package com.github.vendigo.examples.acetest.second;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SecondLauncher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SecondAppConfig.class);
        CountryRepository countryRepository = appContext.getBean(CountryRepository.class);
        countryRepository.save(new Country("Ukraine", "Kyiv", "Europe"));
        countryRepository.save(new Country("Germany", "Berlin", "Europe"));
        countryRepository.save(new Country("Japan", "Tokio", "Asia"));
    }
}
