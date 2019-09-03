package com.avisos.mural.exception;

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

	@ExceptionHandler
    ResponseEntity<ErrorModel> handle(Exception e) {
		
        return new ResponseEntity<ErrorModel>(
        		new ErrorModel(
        				HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e.getCause().getMessage()),
        		new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
