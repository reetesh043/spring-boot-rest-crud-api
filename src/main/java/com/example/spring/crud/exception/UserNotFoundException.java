package com.example.spring.crud.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String str) {
        // calling the constructor of parent Exception
        super(str);
    }
}