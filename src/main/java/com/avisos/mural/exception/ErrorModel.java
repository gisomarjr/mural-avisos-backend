package com.avisos.mural.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * Class model error specific default of system
 * @author Gisomar Jr.
 *
 */
@Getter
@Setter
public class ErrorModel {

    private HttpStatus httpStatus;

    private LocalDateTime timestamp;

    private String message;

    private String details;

    public ErrorModel(HttpStatus httpStatus, String message, String details) {
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }
}
