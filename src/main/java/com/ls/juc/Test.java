package com.ls.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//买票
public class Test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i <200 ; i++) {
                ticket.sale();
            }

        },"A").start();
        new Thread(()->{
            for (int i = 0; i <200 ; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i <200 ; i++) {
                ticket.sale();
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i <200 ; i++) {
                ticket.sale();
            }
        },"D").start();
    }

}
//票
class Ticket{
    private  int count=500;
    Lock lock=new ReentrantLock();
    public void sale(){

        lock.lock();
        try {
            while (count>0){
                count--;
                System.out.println(Thread.currentThread().getName()+"卖出了1张，剩余："+count);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            lock.unlock();
        }

    }

}
