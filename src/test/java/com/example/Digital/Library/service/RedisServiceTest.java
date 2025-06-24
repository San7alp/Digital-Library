package com.example.Digital.Library.service;

import com.example.Digital.Library.DigitalLibraryApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DigitalLibraryApplication.class )
public class RedisServiceTest {
    private final RedisService redisService;
    @Autowired
    public RedisServiceTest(RedisService redisService) {
        this.redisService = redisService;
    }


    @Test
    void divideTwoNumbers_whenInputsAreValidButAisLessThan20() throws Exception{
        int a=10;
        int b=5;
        double res=this.redisService.divideTwoNumbers(a,b);

        Assertions.assertEquals(0.0,res);
    }
    @Test
    void divideTwoNumbers_whenInputsWhenDivisorIs0(){
        int a=10;
        int b=0;
        Assertions.assertThrows(Exception.class,()-> {
            double res = this.redisService.divideTwoNumbers(a, b);
        });

    }
}
