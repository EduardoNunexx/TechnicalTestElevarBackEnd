package com.elevarvendas.technicalTest.exceptions;

import com.elevarvendas.technicalTest.dto.exception.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private ExceptionResponseDTO buildResponseDTO(WebRequest webRequest, Exception exception){
        return new ExceptionResponseDTO(new Date(),webRequest.getDescription(false), exception.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handlerException(WebRequest webRequest, Exception exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buildResponseDTO(webRequest,exception));
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handlerResourceNotFoundException(WebRequest webRequest, ResourceNotFoundException resourceNotFoundException){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(buildResponseDTO(webRequest,resourceNotFoundException));
    }
}
