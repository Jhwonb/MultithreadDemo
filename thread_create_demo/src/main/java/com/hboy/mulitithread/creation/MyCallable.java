package com.hboy.mulitithread.creation;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @Title MyCallable
 * @Description
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/8 17:03
 * @Version 1.0.0
 */

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i = 0; i < 10; i++){
            // Thread.currentThread().getName() ��ȡ��ǰ�̵߳�����
            System.out.println(Thread.currentThread().getName() + "ִ��ʱ��:" + new Date().getTime() + ";ִ�д���:" + i);
        }
        // ����ִ�н�� ͨ��myCallable.get()��ȡ
        return "�ҵ�Callable�Ѿ�ִ�гɹ�����";
    }
}
