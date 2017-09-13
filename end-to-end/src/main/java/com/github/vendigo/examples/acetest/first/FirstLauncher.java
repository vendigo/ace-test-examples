package com.github.vendigo.examples.acetest.first;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;

public class FirstLauncher {

    public static void main(String[] args) {
        if (args.length == 1 && Objects.equals(args[0], "-fail")) {
            throw new RuntimeException("App failed");
        }

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(FirstAppConfig.class);
        PersonRepository personRepository = appContext.getBean(PersonRepository.class);
        personRepository.save(new Person("Petya", 12, "Ukraine"));
        personRepository.save(new Person("Eric", 10, "USA"));
    }
}
