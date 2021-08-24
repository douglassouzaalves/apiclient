package br.com.example.api.exception.handler;


import br.com.example.api.exception.ResourceNotFoundDetails;
import br.com.example.api.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice //informando ao controller que é uma classe que possui informações que devem ser utilizadas
public class RestExceptionHandler extends Throwable {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException) {
        ResourceNotFoundDetails rnfDetais;
        rnfDetais = ResourceNotFoundDetails.ResourceNotFoundDetailsBuilder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .details(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetais, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(NumberFormatException.class)
//    public ResponseEntity<?> handleResourceBadRequest(NumberFormatException numberFormatException) {
//        ResourceNotFoundDetails rnfDetais;
//        rnfDetais = ResourceNotFoundDetails.ResourceNotFoundDetailsBuilder.newBuilder()
//                .timestamp(new Date().getTime())
//                .status(HttpStatus.BAD_REQUEST.value())
//                .title("Error...")
//                .details(numberFormatException.getMessage())
//                .developerMessage(numberFormatException.getClass().getName())
//                .build();
//        return new ResponseEntity<>(rnfDetais, HttpStatus.BAD_REQUEST);
//    }


}

