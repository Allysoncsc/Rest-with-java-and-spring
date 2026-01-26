package br.com.allysoncsc.rest_with_java_spring_erudio.service;


import br.com.allysoncsc.rest_with_java_spring_erudio.data.dto.PersonDTO;
import br.com.allysoncsc.rest_with_java_spring_erudio.exception.ResourceNotFoundException;
import br.com.allysoncsc.rest_with_java_spring_erudio.mapper.ObjectMapper;
import br.com.allysoncsc.rest_with_java_spring_erudio.model.Person;
import br.com.allysoncsc.rest_with_java_spring_erudio.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());


    public List<PersonDTO> findAll(){
//        List<Person> persons =  new ArrayList<Person>();
//        for(int i = 0; i<5;i++){
//            Person person = mockPerson(i);
//            persons.add(person);
//        }

        return ObjectMapper.parseListObjects(personRepository.findAll(),PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        logger.info("Finding one person!");

//        Person person = new Person();
//        person.setId(counter.incrementAndGet());
//        person.setFirstName("Allyson");
//        person.setLastName("Correia");
//        person.setAddress("Ceará - Brasil");
//        person.setGender("Male");

        var entity = personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));
        return ObjectMapper.parseObject(entity,PersonDTO.class);
    }


    public PersonDTO mockPerson(int i){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName "+i);
        person.setLastName("LastName "+i);
        person.setAddress("Some place in Brasil");
        person.setGender(i%2==0? "Male":"Female");
        return ObjectMapper.parseObject(person,PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one Person");
        var entity = ObjectMapper.parseObject(person,Person.class);

        return ObjectMapper.parseObject(personRepository.save(entity),PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Updating one person");
        var p2= personRepository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));
        var entity = ObjectMapper.parseObject(person,Person.class);
        return ObjectMapper.parseObject(personRepository.save(entity),PersonDTO.class);
    }

    public ResponseEntity<?> delete(Long id){
        var p2= personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));
        personRepository.delete(p2);
        return ResponseEntity.noContent().build();
    }
}
