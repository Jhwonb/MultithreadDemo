package com.hboy;

/**
 * @Title DeadLockDemo
 * @Description 演示死锁的Demo
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/3 14:38
 * @Version 1.0.0
 */

public class DeadLockDemo {
    public static void main(String[] args) {
        // 1、创建两个DeadLockRunnable实例：flag = 1 和 flag = 2
        DeadLockRunnable runnable1 = new DeadLockRunnable(1);
        DeadLockRunnable runnable2 = new DeadLockRunnable(2);
        // 2、创建两个线程去执行DeadLockRunnable实例
        Thread thread1 = new Thread(runnable1, "runnable1");
        Thread thread2 = new Thread(runnable2, "runnable2");
        thread1.start();
        thread2.start();
    }
}
