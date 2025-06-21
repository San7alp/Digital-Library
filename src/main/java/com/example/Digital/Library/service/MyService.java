package com.example.Digital.Library.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public double divideTwoNumbers(int a ,int b) throws Exception{
        if(b==0){
            throw new ArithmeticException("Problem");
        }
        if(a>=20){
            return (double) a/b;

        }
        return 0D;
    }
}
