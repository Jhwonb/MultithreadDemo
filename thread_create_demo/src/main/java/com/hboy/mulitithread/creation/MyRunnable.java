package com.hboy.mulitithread.creation;

import java.util.Date;

/**
 * @Title MyRunnable
 * @Description
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/8 16:59
 * @Version 1.0.0
 */

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "ִ��ʱ��:" + new Date().getTime() + ";ִ�д���:" + i);
        }
    }
}
