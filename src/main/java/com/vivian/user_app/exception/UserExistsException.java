package com.vivian.user_app.exception;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String message){
        super(message);
    }
}
