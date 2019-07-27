package com.jam.train.gradbatis.rpc.server.impl;

import com.jam.train.gradbatis.rpc.server.IHelloService;

import java.util.Date;

public class HelloServiceImpl implements IHelloService {

    private static final long serialVersionUID = 2900900865650326876L;


    @Override
    public String sayHello(String name, String msg) {
        String now = new Date().toLocaleString();
        return String.format("%s : %s说:%s",now,name,msg);
    }
}
