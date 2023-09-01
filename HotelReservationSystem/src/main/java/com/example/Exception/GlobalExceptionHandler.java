package com.example.Exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ValidationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> map = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) ->

		{
			String fieldName = ((FieldError) error).getField();
			String messsage = error.getDefaultMessage();
			map.put(fieldName, messsage);
			System.out.println(fieldName+" "+messsage);

		});

		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(ValidationException.class) // Handle custom ValidationException for Manager entity
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ResponseEntity<Object> handleManagerValidationException(ValidationException ex) {
//        return new ResponseEntity<Object>("Manager Validation failed", Collections.singletonList(ex.getMessage()));
//    }

}