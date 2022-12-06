package com.learn.startup.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ CustomException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
      Exception ex, WebRequest request) {
		
		ExceptionBody exceptionBody = new ExceptionBody();
	    exceptionBody.setErrorMessage(ex.getMessage());
	    exceptionBody.setUserFreidnlyError("Na Ho payega bhiya aapse");
		
        return new ResponseEntity<Object>(
        		exceptionBody, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

}
