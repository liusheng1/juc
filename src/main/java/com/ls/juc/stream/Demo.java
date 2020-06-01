package com.ls.juc.stream;

import java.util.stream.LongStream;

public class Demo {
    public static void main(String[] args) {
        System.out.println(LongStream.range(0, 1000000001).parallel().reduce(0, Long::sum));

    }
}
class User{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
     User(int age,String name){

     }
}
