package com.hboy.mulitithread.creation;

import java.util.Date;

/**
 * @Title MyThread
 * @Description �����̵߳��Ĵ�ʽ֮һ �̳�Thread
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/8 16:39
 * @Version 1.0.0
 */

public class MyThread extends Thread{

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            // Thread.currentThread().getName() ��ȡ��ǰ�̵߳�����
            System.out.println(Thread.currentThread().getName() + "ִ��ʱ��:" + new Date().getTime() + ";ִ�д���:" + i);
        }
    }
}
