package com.hboy;

/**
 * @Title DeadLockDemo
 * @Description ��ʾ������Demo
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/3 14:38
 * @Version 1.0.0
 */

public class DeadLockDemo {
    public static void main(String[] args) {
        // 1����������DeadLockRunnableʵ����flag = 1 �� flag = 2
        DeadLockRunnable runnable1 = new DeadLockRunnable(1);
        DeadLockRunnable runnable2 = new DeadLockRunnable(2);
        // 2�����������߳�ȥִ��DeadLockRunnableʵ��
        Thread thread1 = new Thread(runnable1, "runnable1");
        Thread thread2 = new Thread(runnable2, "runnable2");
        thread1.start();
        thread2.start();
    }
}
