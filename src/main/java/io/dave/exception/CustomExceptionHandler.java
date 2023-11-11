package io.dave.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<ErrorMesage> handleCompanyNotFoundException(
			CompanyNotFoundException cnfe)
	{
		return ResponseEntity.internalServerError().body(
				new ErrorMesage(
						new Date().toString(), 
						cnfe.getMessage(), 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), 
						HttpStatus.INTERNAL_SERVER_ERROR.name()
						)
				
				);
	}
}
