package com.ls.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {
    public static void main(String[] args) {
        PrintABCD printABCD = new PrintABCD();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printABCD.printA();
            }

        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printABCD.printB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printABCD.printC();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printABCD.printD();
            }
        }, "D").start();

    }
}

class PrintABCD {

    private String flag = "A";
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    Condition conditionD = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (flag != "A") {

                conditionA.await();

            }
            System.out.println(Thread.currentThread().getName() + "->A");
            flag = "B";
            conditionB.signal();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void printB() {

        lock.lock();
        try {
            while (flag != "B") {

                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "->B");
            flag = "C";
            conditionC.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void printC() {
        lock.lock();
        try {
            while (flag != "C") {

                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName() + "->C");
            flag = "D";
            conditionD.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void printD() {

        lock.lock();
        try {
            while (flag != "D") {

                conditionD.await();
            }
            System.out.println(Thread.currentThread().getName() + "->D");
            flag = "A";
            conditionA.signal();



        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

}
