package com.example.product.CustomErrorHandler;





public class NotFound extends RuntimeException{

    public NotFound(String message) {
        super(message);
    }
}
