package br.com.allysoncsc.rest_with_java_spring_erudio.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {

}
