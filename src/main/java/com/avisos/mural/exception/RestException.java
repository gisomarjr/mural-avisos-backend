package com.avisos.mural.exception;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.data.rest.webmvc.RepositoryRestExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Create controller advice for Rest
 * @author Gisomar Jr.
 *
 */
@ControllerAdvice(basePackageClasses = RepositoryRestExceptionHandler.class)
public class RestException extends ResponseEntityExceptionHandler {

	@ExceptionHandler()
    ResponseEntity<ErrorModel> handle(Exception e) {
		
		Throwable cause = e.getCause().getCause();
		
		if(cause instanceof ConstraintViolationException ) {
			
			Set<ConstraintViolation<?>> violationsList = ((ConstraintViolationException) cause).getConstraintViolations();
			
			 return new ResponseEntity<>(
		        		new ErrorModel(
		        				HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), violationsList.iterator().next().getMessageTemplate()),
		        		new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
        return new ResponseEntity<>(
        		new ErrorModel(
        				HttpStatus.INTERNAL_SERVER_ERROR, "GENERICO", e.getMessage()),
        		new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
