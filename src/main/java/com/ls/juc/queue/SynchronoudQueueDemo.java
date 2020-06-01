package com.ls.juc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;



public class SynchronoudQueueDemo {
    //同步队列
    public static void main(String[] args) {
        BlockingQueue<String> strings = new SynchronousQueue<>();
        new Thread(()->{


        },"A").start();
    }
}
