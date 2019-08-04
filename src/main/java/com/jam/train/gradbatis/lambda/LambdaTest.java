package com.jam.train.gradbatis.lambda;

import java.util.Date;

public class LambdaTest {

    public static void main(String[] args) {

        MathOperation mathOperation = (int a,int b)-> {return  a + b;};

        int opa =  mathOperation.operation(1,2);

        System.out.println(opa);

        GreetingService greetingService = (msg)-> System.out.println(new Date().toLocaleString() + msg);

        greetingService.greeting("你好");
        greetingService.greeting2("你好");
        GreetingService.gg("hh");


    }

}
