package com.jam.train.gradbatis.rpc.server;

import java.io.IOException;

public interface Server  {
    int PORT = 8888;

    void start() throws IOException;

    void stop();

    void register(Class<? extends IRpcService> serviceInterface, Class<? extends IRpcService> impl );
}
