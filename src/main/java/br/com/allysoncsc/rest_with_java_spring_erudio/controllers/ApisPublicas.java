package br.com.allysoncsc.rest_with_java_spring_erudio.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApisPublicas {

    @GetMapping("/teste")
    public String testeApi(){

        return "TESTE";
    }

}
