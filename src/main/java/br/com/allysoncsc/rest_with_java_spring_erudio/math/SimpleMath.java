package br.com.allysoncsc.rest_with_java_spring_erudio.math;


import br.com.allysoncsc.rest_with_java_spring_erudio.exception.UnsupportedMathOperationException;
import br.com.allysoncsc.rest_with_java_spring_erudio.service.NumberConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class SimpleMath {

    @Autowired
    private NumberConverter nConverter;

    public Double sum(Double numberOne,Double numberTwo) {

        return numberOne + numberTwo;
    }


    public Double subtract( Double numberOne, Double numberTwo) {

        return numberOne - numberTwo;
    }
}
