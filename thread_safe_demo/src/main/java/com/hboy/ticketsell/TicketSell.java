package com.hboy.ticketsell;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title ticket
 * @Description
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/10 17:06
 * @Version 1.0.0
 */

public class TicketSell implements Runnable {

    // 电影票的总数量
    private int ticketNum = 100;
    private Object obj = new Object();
    // 重入锁
    // 参数为是否为公平锁， true：为公平锁，所有线程都拥有执行权 false:非公平锁、独占锁
    private Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            // 解决线程安全问题
            // 1、同步代码块
//            synchronized (obj){
//                if (ticketNum > 0) {
//                    // 先让线程睡眠100ms
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    // 打印剩余电影票的数量，并且电影票减一
//                    String name = Thread.currentThread().getName();
//                    System.out.println("线程" + name + "剩余电影票：" + ticketNum--);
//                }
//            }

            // 2、同步方法
//            saleTicket();

            // 3、同步锁
            // 加同步锁
            lock.lock();
            try {
                if (ticketNum > 0) {
                    // 先让线程睡眠100ms
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 打印剩余电影票的数量，并且电影票减一
                    String name = Thread.currentThread().getName();
                    System.out.println("线程" + name + "剩余电影票：" + ticketNum--);
                }
            }finally {
                // 释放同步锁
                lock.unlock();
            }
        }
    }

    /**
     * 2、同步方法解决线程安全问题
     * 注：对于static方法 就是synchronized(TicketSell.class)，而对于非static方法 就是synchronized(this)
     * */
    private synchronized void saleTicket(){
        if (ticketNum > 0) {
            // 先让线程睡眠100ms
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 打印剩余电影票的数量，并且电影票减一
            String name = Thread.currentThread().getName();
            System.out.println("线程" + name + "剩余电影票：" + ticketNum--);
        }
    }
}
