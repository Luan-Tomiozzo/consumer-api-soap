/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consumer.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Luan Pedro Tomiozzo
 */
@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        RestResponseDetails responseDetails = new RestResponseDetails();
        return super.handleExceptionInternal(ex, responseDetails, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponseDetails> handlerException(Exception ex, HttpServletRequest request) {
        RestResponseDetails error = new RestResponseDetails();
        error.setStatus(BAD_REQUEST.value());
        error.setError("Exception");
        error.setDetails(ex.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(BAD_REQUEST).body(error);
    }

    @ExceptionHandler(RestResponseException.class)
    public ResponseEntity<RestResponseDetails> handlerResponseException(RestResponseException ex, HttpServletRequest request) {
        RestResponseDetails error = new RestResponseDetails();
        error.setStatus(BAD_REQUEST.value());
        error.setError("RestResponseException");
        error.setDetails(ex.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(BAD_REQUEST).body(error);
    }

}
