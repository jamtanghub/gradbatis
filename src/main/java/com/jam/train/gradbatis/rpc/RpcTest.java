package com.jam.train.gradbatis.rpc;

import com.jam.train.gradbatis.rpc.client.Client;
import com.jam.train.gradbatis.rpc.server.IHelloService;

import java.net.InetSocketAddress;


/**
 * 手把手教你写一个RPC
 * https://www.cnblogs.com/dwlovelife/p/10320505.html
 *
 *
 */

public class RpcTest {

    public static void main(String[] args) {
        IHelloService helloService = Client.getRemoteProxyObj(IHelloService.class,new InetSocketAddress(8888));

        String re =   helloService.sayHello("张三","周末愉快");

        System.out.println(re);
    }

}
