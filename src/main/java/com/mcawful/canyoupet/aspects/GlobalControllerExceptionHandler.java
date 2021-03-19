/**
 * 
 */
package com.mcawful.canyoupet.aspects;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Advice class designed to handle HTTP response codes for various exceptions
 * that get thrown by the controllers.
 * 
 * @author Michael McAuliffe
 *
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

	/**
	 * Method to handle the HTTP response code when a
	 * {@link DataIntegrityViolationException} occurs. Response code is 409.
	 */
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<String> handleConflict() {
		return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409
	}

	/**
	 * Method to handle the HTTP response code when a {@link NoSuchElementException}
	 * occurs. Response code is 404.
	 */
	@ExceptionHandler(value = { NoSuchElementException.class, EmptyResultDataAccessException.class })
	public ResponseEntity<String> handleNotFound() {
		return ResponseEntity.notFound().build(); // 404
	}

	/**
	 * Method to handle the HTTP response code when a
	 * {@link IllegalArgumentException} occurs. Response code is 400.
	 */
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<String> handleBadRequest() {
		return ResponseEntity.badRequest().build(); // 400
	}
}
