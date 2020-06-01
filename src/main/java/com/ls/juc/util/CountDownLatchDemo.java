package com.ls.juc.util;

import java.lang.management.GarbageCollectorMXBean;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
      int a = 15;
        CountDownLatch countDownLatch=new CountDownLatch(10);
        for (int i = 0; i <12 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            },String.valueOf(i)).start();

        }
        countDownLatch.await();
        System.out.println("hjakjjhk");
    }
}
