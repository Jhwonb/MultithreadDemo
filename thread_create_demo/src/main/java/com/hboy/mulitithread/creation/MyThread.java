package com.hboy.mulitithread.creation;

import java.util.Date;

/**
 * @Title MyThread
 * @Description 创建线程的四大方式之一 继承Thread
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/8 16:39
 * @Version 1.0.0
 */

public class MyThread extends Thread{

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            // Thread.currentThread().getName() 获取当前线程的名称
            System.out.println(Thread.currentThread().getName() + "执行时间:" + new Date().getTime() + ";执行次数:" + i);
        }
    }
}
