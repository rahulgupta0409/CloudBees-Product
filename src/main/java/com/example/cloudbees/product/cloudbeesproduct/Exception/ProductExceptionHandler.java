package com.example.cloudbees.product.cloudbeesproduct.Exception;

public class ProductExceptionHandler extends RuntimeException{

    public ProductExceptionHandler(String message){
        super(message);
    }

    public ProductExceptionHandler(String message, Throwable throwable){
        super(message, throwable);
    }
}
