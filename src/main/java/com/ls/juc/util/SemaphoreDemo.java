package com.ls.juc.util;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {
        /**
         * 抢车位
         */

        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <7 ; i++) {
            int count=i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("第"+count +"两车子停在停车位了");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("第"+count+"两车子走了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }


            },String.valueOf(i)).start();
        }
    }
}
