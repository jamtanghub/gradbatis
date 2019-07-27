package com.jam.train.gradbatis.rpc.server.impl;

import com.jam.train.gradbatis.rpc.server.IHelloService;
import com.jam.train.gradbatis.rpc.server.IRpcService;
import com.jam.train.gradbatis.rpc.server.Server;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServerCenter implements Server {

    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
            5,
            20,
            200,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(10));

    private static final Map<String, Class<?>> serviceRegistery = new HashMap<>();

    @Override
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(PORT));

        try {
            while (true) {
                Socket socket =  serverSocket.accept();
                poolExecutor.execute(new ServiceTask(socket));
            }
        } finally {
            serverSocket.close();
        }
    }

    @Override
    public void stop() {
           poolExecutor.shutdown();
    }

    @Override
    public void register(Class<? extends IRpcService> serviceInterface, Class<? extends IRpcService> impl) {
        serviceRegistery.put(serviceInterface.getName(),impl);
    }


    private static class ServiceTask implements Runnable{

        private Socket client;

        public ServiceTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {

            ObjectInputStream input = null;
            ObjectOutputStream output = null;

            try{
                input = new ObjectInputStream(client.getInputStream());

                String serviceName = input.readUTF();  //服务名
                String methodName = input.readUTF();   //方法名

                Class<?>[] parameterTypes = (Class<?>[]) input.readObject(); //参数类型
                Object[] arguments = (Object[]) input.readObject();          //参数列表

                Class<?> serviceClass = serviceRegistery.get(serviceName);
                Method method = serviceClass.getMethod(methodName,parameterTypes);

                Object result = method.invoke(serviceClass.newInstance(), arguments);

                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);
            }catch (IOException ioe){

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
    }


    public static void main(String[] args) throws IOException {

        ServerCenter serverCenter = new ServerCenter();
        serverCenter.register(IHelloService.class,new HelloServiceImpl().getClass());
        serverCenter.start();

    }


}
