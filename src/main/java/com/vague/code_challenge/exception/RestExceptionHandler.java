package com.vague.code_challenge.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vague.code_challenge.service.MessageLocaleService;
import com.vague.code_challenge.util.RestValidationError;

@RestControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
    MessageLocaleService messageLocaleService;
		
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		final List<String> errors = new ArrayList<String>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
        		String value = "";
        		if (error.getRejectedValue() != null) {
        			value = error.getRejectedValue().toString();
        		}
        		String err = messageLocaleService.getMessage(error.getDefaultMessage(), value);
        		errors.add(err);
        }
		return new ResponseEntity<Object>(new RestValidationError(new Date(), "Validation Failed", errors), HttpStatus.BAD_REQUEST);
	}

}