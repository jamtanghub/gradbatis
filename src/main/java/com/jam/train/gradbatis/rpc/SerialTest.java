package com.jam.train.gradbatis.rpc;

import lombok.Data;

import java.io.*;


public class SerialTest implements Serializable{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws Exception {


        File file = new File("D:/serial");

        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream objOutput = new ObjectOutputStream(fout);

        SerialTest serialTest = new SerialTest();
        serialTest.setAge(100);
        serialTest.setName("啊啊啊");

        objOutput.writeObject(serialTest);

        objOutput.close();
        fout.close();


        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream objInput = new ObjectInputStream(fin);

        SerialTest test = (SerialTest) objInput.readObject();


        System.out.println(test.getName());




    }

}
