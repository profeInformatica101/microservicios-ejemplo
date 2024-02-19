package com.dwes.servicio.producto.expcecion;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.dwes.servicio.producto.dto.MensajeResponse;



@ControllerAdvice
public class GlobalExceptionHandler {
    
	 @ExceptionHandler(IllegalArgumentException.class)
	    public ResponseEntity<MensajeResponse> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
		 MensajeResponse errorDetails = new MensajeResponse(
	            new Date(),
	            ex.getMessage(),
	            request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	    }
    
    
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<MensajeResponse> handleJabonNotFoundException(ProductoNotFoundException ex, WebRequest request) {
    	MensajeResponse errorDetails = new MensajeResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MensajeResponse> handleNoHandlerFoundException(NoHandlerFoundException ex, WebRequest request) {
    	MensajeResponse errorDetails = new MensajeResponse(
            new Date(),
            "Ruta no encontrada",
            ex.getRequestURL());

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeResponse> handleGlobalException(Exception ex, WebRequest request) {
    	MensajeResponse errorDetails = new MensajeResponse(
            new Date(),
            "Error interno del servidor",
            request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}