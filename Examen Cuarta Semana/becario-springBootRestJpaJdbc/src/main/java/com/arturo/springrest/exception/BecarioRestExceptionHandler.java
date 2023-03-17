package com.arturo.springrest.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BecarioRestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<BecarioErrorResponse> handleException(BecarioNotFoundException exc) {

		// CREAR UN NUEVO BecarioErrorResponse

		BecarioErrorResponse error = new BecarioErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(LocalDateTime.now());

		// REGRESAR LA RESPUESTA ResponseEntity

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<BecarioErrorResponse> handleException(Exception exc) {

		// CREAR UN NUEVO BecarioErrorResponse
		BecarioErrorResponse error = new BecarioErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(LocalDateTime.now());

		// REGRESAR LA RESPUESTA ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
