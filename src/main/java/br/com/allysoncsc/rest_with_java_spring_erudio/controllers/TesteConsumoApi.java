package br.com.allysoncsc.rest_with_java_spring_erudio.controllers;


import br.com.allysoncsc.rest_with_java_spring_erudio.service.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request/v1")
public class TesteConsumoApi {

    @Autowired
    Principal main;

    @GetMapping("/conselho")
    public String aconcelhar(){return main.pegaConselho();}
}
