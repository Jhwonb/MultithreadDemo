package com.hboy.com;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Title cyclicBarrierDemo
 * @Description
 * CyclicBarrier：实现让一组线程等待至某个状态之后在全部执行 底层是使用ReentranLock和Condition实现的
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/12 15:51
 * @Version 1.0.0
 */

public class CyclicBarrierDemo {

    // 参数是参与CyclicBarrier的线程数
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public void startThread(){
        // 获取当前线程的名称
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在准备...");
        // 调用CyclicBarrier的await方法等待线程全部执行完毕
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 打印线程启动成功的信息 打印时间戳，看这一组线程是否是同时启动
        System.out.println(name + "已经启动完毕：" + new Date().getTime());
    }

    public static void main(String[] args) {
        final CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                cyclicBarrierDemo.startThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                cyclicBarrierDemo.startThread();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                cyclicBarrierDemo.startThread();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
