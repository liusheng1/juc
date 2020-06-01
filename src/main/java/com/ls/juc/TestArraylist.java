package com.ls.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestArraylist {
    public static void main(String[] args) {
        //List list=new CopyOnWriteArrayList<>();
        List list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,32));
                System.out.println(list);
            },i+"").start();
        }

    }
}
