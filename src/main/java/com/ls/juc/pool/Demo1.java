package com.ls.juc.pool;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) {

        /**
         * 三大方法 ，七大参数，四大拒绝策略
         */
        //单个线程池
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //缓存线程池
        // ExecutorService threadPool = Executors.newCachedThreadPool();
        //定长线程池
        // ExecutorService threadPool = Executors.newFixedThreadPool(5);

        //cpu 密集型获取CPU核数
        int cup_count = Runtime.getRuntime().availableProcessors();
        //IO密集型

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5,                                  //核心线程数
                cup_count,                              //最大线程数   cpu 密集型获取CPU核数  max=cpu   IO密集型   大于程序最大大型任务数
                10,                                //保持时间
                TimeUnit.SECONDS,                               //时间单位
                new ArrayBlockingQueue<>(5),            //阻塞队列
                Executors.defaultThreadFactory(),               //线程池工厂
                //  new ThreadPoolExecutor.AbortPolicy()            //拒绝策略  1.拒绝处理超出任务，并抛出异常
                //  new ThreadPoolExecutor.CallerRunsPolicy()       //         2.拒绝直接处理任务，通过代理处理任务
                new ThreadPoolExecutor.DiscardOldestPolicy()    //         3.尝试和 最早的线程竞争 成功继续执行，失败不抛出异常
                // new ThreadPoolExecutor.DiscardPolicy()          //          4.拒绝处理超出任务，不抛出异常

        );
        try {
            for (int i = 0; i < 100; i++) {
                final int count = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "->>>" + count);
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }
}
