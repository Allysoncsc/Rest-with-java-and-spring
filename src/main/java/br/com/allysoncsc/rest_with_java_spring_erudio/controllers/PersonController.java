package br.com.allysoncsc.rest_with_java_spring_erudio.controllers;


import br.com.allysoncsc.rest_with_java_spring_erudio.model.Person;
import br.com.allysoncsc.rest_with_java_spring_erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/findbyid/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id){
        return personService.findById(id);
    }

    @GetMapping("/findall")
    public List<Person> findAll(){
        return personService.findAll();
    }

}
