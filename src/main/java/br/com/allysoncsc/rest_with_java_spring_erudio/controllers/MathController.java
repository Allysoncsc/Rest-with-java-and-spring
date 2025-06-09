package br.com.allysoncsc.rest_with_java_spring_erudio.controllers;


import br.com.allysoncsc.rest_with_java_spring_erudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo)throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value.");
        return converToDouble(numberOne) + converToDouble(numberTwo);
    }

    private Double converToDouble(String strNumber) throws IllegalArgumentException{
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value.");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",",".");
        //regex valida numeros positivos que vão de 0 a 9 e após a vígurla vão de 0 a 9
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");

    }
}
