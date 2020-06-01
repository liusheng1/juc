package com.ls.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    /**
     * 阻塞队列
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueueDemo blockingQueueDemo = new BlockingQueueDemo();
        blockingQueueDemo.test1();
        blockingQueueDemo.test2();
        blockingQueueDemo.test3();

    }

    /**
     * 抛出异常
     */
    public void test1() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        System.out.println(arrayBlockingQueue.add("A"));
        System.out.println(arrayBlockingQueue.add("B"));
        System.out.println(arrayBlockingQueue.add("C"));

        System.out.println("以上正常");
        // System.out.println(arrayBlockingQueue.add("D"));


        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println("以上正常");
        // System.out.println(arrayBlockingQueue.remove());
        //判断首元素
       // System.out.println(arrayBlockingQueue.element());

    }

    /**
     * 不抛出异常
     */
    void test2() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        System.out.println(arrayBlockingQueue.offer("A"));
        System.out.println(arrayBlockingQueue.offer("B"));
        System.out.println(arrayBlockingQueue.offer("C"));

        System.out.println(arrayBlockingQueue.offer("D"));


        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());


    }

    /**
     * 不抛出异常 等待超时超时
     */
    void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

        arrayBlockingQueue.put("A");
        arrayBlockingQueue.put("B");
        arrayBlockingQueue.put("C");
        arrayBlockingQueue.put("D");


        arrayBlockingQueue.take();
        arrayBlockingQueue.take();
        arrayBlockingQueue.take();
        arrayBlockingQueue.take();




    }

    /**
     * 不抛出异常 阻塞
     */
    void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        System.out.println(arrayBlockingQueue.offer("A"));
        System.out.println(arrayBlockingQueue.offer("B"));
        System.out.println(arrayBlockingQueue.offer("C"));
        System.out.println(arrayBlockingQueue.offer("D", 2, TimeUnit.SECONDS));


        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));


    }
}
