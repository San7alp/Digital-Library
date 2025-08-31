package com.example.Digital.Library.Exception;

public class IncorrectCredentialException extends RuntimeException{
    public IncorrectCredentialException(String message){
        super(message);
    }
}
