package com.ls.juc.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyciicBarrierDemo {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("线程全部执行完成");
        });
        for (int i = 0; i < 7; i++) {
            int count= i;
            new Thread(()->{
                System.out.println("第"+count+"线程执行完成");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();

        }

    }
}
