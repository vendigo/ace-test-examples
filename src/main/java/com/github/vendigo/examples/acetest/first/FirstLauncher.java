package com.github.vendigo.examples.acetest.first;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FirstLauncher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(FirstAppConfig.class);
        PersonRepository personRepository = appContext.getBean(PersonRepository.class);
        personRepository.save(new Person("Petya", 12, "Ukraine"));
        personRepository.save(new Person("Eric", 10, "USA"));
    }
}
