package com.faisal.moneymanager.exceptions;

import com.faisal.moneymanager.exceptions.BaseException;
import com.faisal.moneymanager.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {



    //this exception can be inside separate Exception Class

    public static class EntityNotFoundException extends BaseException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }


    //to handle custom exception we have to do this
    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {

        ErrorResponse error =  ErrorResponse.builder().message(ex.getMessage()).build();

        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    }


    // this are overridden methods from ResponseEntityExceptionHandler
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }

        ErrorResponse error =  ErrorResponse.builder()
                .errors(getErrorsFromMethodArgumentNotValidException(ex))
                .status(status)
                .details(details)
                .message("Validation Failed")
                .build();
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }

    private Map<String, String> getErrorsFromMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
