package com.ls.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriterLockerDemo {
    /**
     * 读写锁
     */
    public static void main(String[] args) {
       // MyCache myCache = new MyCache();
        MyCacheLock myCache=new MyCacheLock();
        for (int i = 1; i < 500; i++) {
            final String count = String.valueOf(i);
            new Thread(() -> {
                myCache.put(count, count);
            }, String.valueOf(i)).start();

        }
        for (int j = 1; j < 500; j++) {
            final String count = String.valueOf(j);
            new Thread(() -> {
                myCache.get(count);
            }, String.valueOf(j)).start();

        }


    }
}

/**
 * 自定义缓存
 */
class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();


    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object object) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, object);
            System.out.println(Thread.currentThread().getName() + "写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }


    }

}

/**
 * 自定义缓存
 */
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object object) {

        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, object);
        System.out.println(Thread.currentThread().getName() + "写入OK");


    }

    public void get(String key) {

        System.out.println(Thread.currentThread().getName() + "读取" + key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取OK");


    }

}
