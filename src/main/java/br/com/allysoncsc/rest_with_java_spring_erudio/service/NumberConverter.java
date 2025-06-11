package br.com.allysoncsc.rest_with_java_spring_erudio.service;


import br.com.allysoncsc.rest_with_java_spring_erudio.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class NumberConverter {


    public static Double converToDouble(String strNumber) throws IllegalArgumentException{
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value.");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",",".");
        //regex valida numeros positivos que vão de 0 a 9 e após a vígurla vão de 0 a 9
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");

    }
}
