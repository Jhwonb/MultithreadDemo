package com.hboy;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title ReentrantLockDemo
 * @Description 可重入锁的Demo
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/22 15:48
 * @Version 1.0.0
 */

public class ReentrantLockDemo {
    public static void main(String[] args) {
        // 不可重入锁：当线程请求他已经拥有的锁时会阻塞，即他不会再次拿到同一个锁
        // 可重入锁：已经拥该锁的对象可以重复的拥有该锁
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            lock.lock();
            System.out.println("加锁次数：" + (i+1));
        }
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("解锁次数：" + (i+1));
            }finally {
                lock.unlock();
            }
        }
    }
}
