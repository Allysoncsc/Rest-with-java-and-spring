package br.com.allysoncsc.rest_with_java_spring_erudio.service;


import br.com.allysoncsc.rest_with_java_spring_erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());


    public Person findById(String id){
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Allyson");
        person.setLastName("Correia");
        person.setAddress("Ceará - Brasil");
        person.setGender("Male");
        return person;
    }

}
