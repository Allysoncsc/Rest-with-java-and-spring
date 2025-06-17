package br.com.allysoncsc.rest_with_java_spring_erudio.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TesteLogControlelr {

    private Logger logger = LoggerFactory.getLogger(TesteLogControlelr.class.getName());

    @GetMapping("/test")
    public String testLog(){
        logger.debug("Tis is an DEBUS logg");
        logger.info("This is an INFO log");
        logger.warn("This is an WARN log");
        logger.error("This is an ERROR log");
        return "logs generated sucessfully!";
    }
}
