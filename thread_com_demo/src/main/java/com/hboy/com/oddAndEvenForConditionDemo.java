package com.hboy.com;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title oddAndEvenForCondationDemo
 * @Description 线程通信 使用Condition的await()、signal()方法 实现线程的唤醒及休眠
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/12 14:53
 * @Version 1.0.0
 */

public class oddAndEvenForConditionDemo {
    private int i = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * 奇数打印方法，由奇数线程调用
     * @author houby
     * @return void
     * @date 2021/7/12 14:28
     */
    public void odd(){
        // 判断i是否小于10，如果小于10，且为奇数，则进行打印
        while(i < 10) {
            lock.lock();
            try {
                if (i % 2 == 1) {
                    System.out.println("奇数：" + i);
                    i++;
                    // 唤醒偶数线程打印
                    condition.signal();
                } else {
                    try {
                        // 等待偶数线程打印完毕
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }

    /**
     * 偶数打印方法，由偶数线程调用
     * @author houby
     * @return void
     * @date 2021/7/12 14:28
     */
    public void even(){
        // 判断i是否小于10，如果小于10，且为偶数，则进行打印
        while (i < 10) {
            lock.lock();
            try {
                if (i % 2 == 0) {
                    System.out.println("偶数：" + i);
                    i++;
                    // 唤醒奇数线程打印
                    condition.signal();
                } else {
                    try {
                        // 等待奇数线程打印完毕
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        final oddAndEvenForObjectDemo oddEven = new oddAndEvenForObjectDemo();
        // 开启奇数线程打印
        Thread oddThread = new Thread(new Runnable() {
            public void run() {
                oddEven.odd();
            }
        });
        // 开启偶数线程打印
        Thread evenThread = new Thread(new Runnable() {
            public void run() {
                oddEven.even();
            }
        });

        oddThread.start();
        evenThread.start();
    }

}
