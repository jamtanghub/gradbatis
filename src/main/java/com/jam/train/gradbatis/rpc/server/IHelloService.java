package com.jam.train.gradbatis.rpc.server;

public interface IHelloService extends IRpcService {

    String sayHello(String name,String msg);
}
