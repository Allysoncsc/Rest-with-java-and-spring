package br.com.allysoncsc.rest_with_java_spring_erudio.service;


import br.com.allysoncsc.rest_with_java_spring_erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());


    public List<Person> findAll(){
        List<Person> persons =  new ArrayList<Person>();
        for(int i = 0; i<5;i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

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


    public Person mockPerson(int i){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName "+i);
        person.setLastName("LastName "+i);
        person.setAddress("Some place in Brasil");
        person.setGender(i%2==0? "Male":"Female");
        return person;
    }

    public Person create(Person person){
        logger.info("Creating one Person");
        return person;
    }

    public Person update(Person person){
        logger.info("Updating one person");
        return person;
    }
}
