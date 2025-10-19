package com.udc.calculo.financiero.infraestructura.configuracion;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.udc.calculo.financiero.dominio.excepciones.AutorizacionException;
import com.udc.calculo.financiero.dominio.excepciones.CalculoAporteException;
import com.udc.calculo.financiero.dominio.excepciones.ValidationException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(AutorizacionException.class)
	public ResponseEntity<ErrorResponse> handleApiException(
	        AutorizacionException ex,
	        HttpServletRequest request) {

	    ErrorResponse error = new ErrorResponse(
	            LocalDateTime.now(),
	            "ERROR_AUTORIZACION",
	            ex.getMessage(),
	            request.getRequestURI(),
	            401
	    );

	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
	}

    @ExceptionHandler(CalculoAporteException.class)
    public ResponseEntity<ErrorResponse> handleApiException(CalculoAporteException ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                "ERROR CALCULO APORTE",
                ex.getMessage(),                
                request.getRequestURI(),
                500
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex, HttpServletRequest request) {
          ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                "VALIDATION_ERROR",
                ex.getMessage(),                
                request.getRequestURI(),
                400
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String mensaje = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                "VALIDATION_ERROR",
                mensaje,                
                request.getRequestURI(),
                400
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, HttpServletRequest request) {
    	 	 ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                "INTERNAL_ERROR",
                ex.getMessage(),                
                request.getRequestURI(),
                500
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}