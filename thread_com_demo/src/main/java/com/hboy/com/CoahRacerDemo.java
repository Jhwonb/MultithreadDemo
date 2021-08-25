package com.hboy.com;

import java.util.concurrent.CountDownLatch;

/**
 * @Title CoahRacerDemo
 * @Description 线程通信 使用CountDownLatch方法 实现线程的唤醒及休眠
 * CountDownLatch:指的是线程A等待若干个线程执行完毕后，它才执行
 * 实现需求：等所有运动员到齐之后，教练才发出命令开始训练
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/12 15:12
 * @Version 1.0.0
 */


public class CoahRacerDemo {

    // 设置要等待的运动员为3个
    private CountDownLatch countDownLatch = new CountDownLatch(3);

    // 运动员方法，由运动员线程调用
    public void racer(){
        // 获取当前运动员的名称
        String name = Thread.currentThread().getName();
        // 运动员开始准备 打印
        System.out.println("运动员：" + name + "正在准备...");
        // 让运动员睡眠1s 标识运动员在准备
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运动员：" + name + "准备完毕。");
        // 执行计数减一操作
        countDownLatch.countDown();
    }

    // 教练方法，由教练线程调用
    public void coach(){
        // 获取教练名称
        String name = Thread.currentThread().getName();
        // 教练等待所有的运动员准备完毕
        System.out.println(name + "等待运动员准备...");
        // 调用CountDownLatch的wait方法等待其他线程准备完毕
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 所有运动员已经准备就绪，教练开始训练
        System.out.println("所有运动员已经准备就绪，" + name + "开始训练。");

    }

    public static void main(String[] args) {
        final CoahRacerDemo coahRacerDemo = new CoahRacerDemo();
        Thread threadRacer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                coahRacerDemo.racer();
            }
        },"运动员1");
        Thread threadRacer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                coahRacerDemo.racer();
            }
        },"运动员2");
        Thread threadRacer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                coahRacerDemo.racer();
            }
        },"运动员3");
        Thread threadCoach = new Thread(new Runnable() {
            @Override
            public void run() {
                coahRacerDemo.coach();
            }
        },"教练");
        threadCoach.start();
        threadRacer1.start();
        threadRacer2.start();
        threadRacer3.start();
    }
}
