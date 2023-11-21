package com.example.examen.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.examen.dto.ErrorDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerGenericException(HttpServletRequest request, Exception exception){
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setBackMessage(exception.getLocalizedMessage());
		errorDTO.setUrl(request.getRequestURL().toString());
		errorDTO.setMethodo(request.getMethod());
		errorDTO.setTimestamp(LocalDateTime.now());
		errorDTO.setMessage("Error interno en el servidor, vuelva intentarlo");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerMethodArgumentNotValidException(HttpServletRequest request, 
			MethodArgumentNotValidException exception){
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setBackMessage(exception.getLocalizedMessage());
		errorDTO.setUrl(request.getRequestURL().toString());
		errorDTO.setMethodo(request.getMethod());
		errorDTO.setTimestamp(LocalDateTime.now());
		errorDTO.setMessage("Error en la petición enviada");
		System.out.println(exception.getAllErrors().stream().map(each->each.getDefaultMessage())
				.collect(Collectors.toList()));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
	}

}
