package com.hboy.mulitithread.creation;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @Title ThreadExtendDemo
 * @Description 线程的启动类
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/8 16:45
 * @Version 1.0.0
 */

public class ThreadExtendDemo {

    public static void main(String[] args) {
        // 创建线程的有四个方式 1、继承Thread类 2、实现Runnable接口 3、实现Callable接口 4、线程池

        // 1、继承Thread类创建线程
//        MyThread mythread = new MyThread();
//        // 启动自定义线程 start()方法会自动掉用run()方法
//        mythread.start();
//        // 在main主线程中打印信息
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName() + "执行时间:" + new Date().getTime() + ";执行次数：" + i);
//        }

        // 2、实现Runnable接口创建线程
        // 2.1、在main主线程打印信息
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName() + "执行时间:" + new Date().getTime() + ";执行次数：" + i);
//        }
//        // 2.2、通过Thread类执行MyRunnable类
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable,"我的Runnable");
//        thread.start();

        // 3、实现Callable接口创建线程
        // 3.1、创建FutureTask实例 执行MyCallable类
//        Callable callable;
//        FutureTask<String> task = new FutureTask<String>(new MyCallable());
//        // 3.2、创建Thread实例，执行FutureTask
//        Thread thread = new Thread(task,"我的Callable");
//        thread.start();
//        // 3.3、在main主线程打印信息
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName() + "执行时间:" + new Date().getTime() + ";执行次数：" + i);
//        }
//        // 3.4、获取并打印Callable的执行结果
//        try {
//            String result = task.get();
//            System.out.println("MyCallable的执行结果是：" + result);
//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//        }

        // 4、通过线程池执行MyRunnable类
        // 创建里边包含10个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 4.1、通过线程池执行线程
        executorService.execute(new MyRunnable());
        // 4.2、在main主线程打印信息
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "执行时间:" + new Date().getTime() + ";执行次数：" + i);
        }
    }
}
