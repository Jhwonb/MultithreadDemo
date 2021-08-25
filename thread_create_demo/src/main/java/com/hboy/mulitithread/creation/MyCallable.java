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
            // Thread.currentThread().getName() 获取当前线程的名称
            System.out.println(Thread.currentThread().getName() + "执行时间:" + new Date().getTime() + ";执行次数:" + i);
        }
        // 返回执行结果 通过myCallable.get()获取
        return "我的Callable已经执行成功啦！";
    }
}
