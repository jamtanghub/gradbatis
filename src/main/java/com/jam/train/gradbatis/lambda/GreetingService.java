package com.jam.train.gradbatis.lambda;

public interface GreetingService {
    void greeting(String msg);

    //默认方法
    default void greeting2(String msg){
        System.out.println(msg);
    }

    static void gg(String msg){
        System.out.println(msg);
    }

}
