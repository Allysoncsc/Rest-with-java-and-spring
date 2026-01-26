package br.com.allysoncsc.rest_with_java_spring_erudio.controllers;

import br.com.allysoncsc.rest_with_java_spring_erudio.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingsController {

    private static final String  template = "Hello, %s!";
    private static AtomicLong counter = new AtomicLong();
    //http://localhost:8080/greeting?name=Allyson

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }


    @GetMapping("/testget")
    public String teste(@RequestParam(value="name") String name){

        return name;
    }

    @GetMapping("/testepath/{nome}")
    public String tetsPath(@PathVariable("nome") String nome){
        return nome;
    }

}
