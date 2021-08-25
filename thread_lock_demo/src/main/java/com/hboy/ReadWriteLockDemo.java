package com.hboy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Title ReadWriteLockDemo
 * @Description 读写锁的Demo
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/22 15:55
 * @Version 1.0.0
 */

public class ReadWriteLockDemo {
    // 操作的Map对象
    private Map<String, String> map = new HashMap<>();
    // 读写锁
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // 获取读锁
    private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    // 获取写锁
    private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    // 读操作加锁
    public String  get(String key){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读操作已加锁，开始读操作...");
            // 让线程睡眠3s
            TimeUnit.SECONDS.sleep(3);
            return map.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            System.out.println(Thread.currentThread().getName() + "读操作已解锁，读操作已结束...");
            readLock.unlock();
        }
    }

    public void put(String key, String value){
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写操作已加锁，开始写操作...");
            TimeUnit.SECONDS.sleep(3);
            map.put(key,value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + "写操作已解锁，写操作已结束...");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        readWriteLockDemo.put("key1","value1");
        new Thread("读线程1"){
            public void run(){
                System.out.println(readWriteLockDemo.get("key1"));
            }
        }.start();
        new Thread("读线程2"){
            public void run(){
                System.out.println(readWriteLockDemo.get("key1"));
            }
        }.start();
        new Thread("读线程3"){
            public void run(){
                System.out.println(readWriteLockDemo.get("key1"));
            }
        }.start();
    }
}
