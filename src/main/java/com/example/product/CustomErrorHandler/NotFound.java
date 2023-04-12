package com.example.product.CustomErrorHandler;


import org.springframework.http.HttpStatus;

public class NotFound extends RuntimeException{

   private String message;

    public NotFound(String message) {
        super(message);
    }
}
