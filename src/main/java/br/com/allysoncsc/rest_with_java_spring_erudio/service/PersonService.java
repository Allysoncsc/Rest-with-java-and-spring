package br.com.allysoncsc.rest_with_java_spring_erudio.service;


import br.com.allysoncsc.rest_with_java_spring_erudio.dto.ClienteResumoDto;
import br.com.allysoncsc.rest_with_java_spring_erudio.exception.ResourceNotFoundException;
import br.com.allysoncsc.rest_with_java_spring_erudio.model.Person;
import br.com.allysoncsc.rest_with_java_spring_erudio.repository.PersonRepository;
import br.com.allysoncsc.rest_with_java_spring_erudio.repository.query.ClienteQueryRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ClienteQueryRepository clienteQueryRepository;

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public ClienteResumoDto testeJdbc(){
        return clienteQueryRepository.retornarUsu();
    }

    public List<Person> findAll(){
//        List<Person> persons =  new ArrayList<Person>();
//        for(int i = 0; i<5;i++){
//            Person person = mockPerson(i);
//            persons.add(person);
//        }

        return personRepository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one person!");

//        Person person = new Person();
//        person.setId(counter.incrementAndGet());
//        person.setFirstName("Allyson");
//        person.setLastName("Correia");
//        person.setAddress("Ceará - Brasil");
//        person.setGender("Male");

        return personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));
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


        return personRepository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one person");
        var p2= personRepository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));
        return personRepository.save(person);
    }

    public ResponseEntity<?> delete(Long id){
        var p2= personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));
        personRepository.delete(p2);
        return ResponseEntity.noContent().build();
    }
}
