package com.example.demo.Controller;

public class NewsNotFoundException  extends RuntimeException {
    public NewsNotFoundException(String message) {
        super(message);
    }
}

