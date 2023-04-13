package com.example.product.CustomErrorHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFound.class)
    protected ResponseEntity<Object> NotFoundException(NotFound ex, WebRequest request) {
       // return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
         return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST,
         LocalDateTime.now(), ex.getMessage(), ex.getLocalizedMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error = "the request method used is wrong";
        return buildResponseEntity(
                new ApiError(HttpStatus.BAD_REQUEST, LocalDateTime.now(), error, ex.getLocalizedMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error = "Activity timeout, sorry";
        return buildResponseEntity(
                new ApiError(HttpStatus.BAD_REQUEST, LocalDateTime.now(), error, ex.getLocalizedMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error = "Failed due to bad format of JSON body submitted.";
        return buildResponseEntity(
                new ApiError(HttpStatus.BAD_REQUEST, LocalDateTime.now(), error, ex.getLocalizedMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
            HttpStatusCode statusCode, WebRequest request) {
        String error = "Failed due to internal exception.";
        return buildResponseEntity(
                new ApiError(HttpStatus.BAD_REQUEST, LocalDateTime.now(), error, ex.getLocalizedMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
