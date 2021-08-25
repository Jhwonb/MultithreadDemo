package com.hboy.mulitithread.creation;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @Title ThreadExtendDemo
 * @Description �̵߳�������
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/8 16:45
 * @Version 1.0.0
 */

public class ThreadExtendDemo {

    public static void main(String[] args) {
        // �����̵߳����ĸ���ʽ 1���̳�Thread�� 2��ʵ��Runnable�ӿ� 3��ʵ��Callable�ӿ� 4���̳߳�

        // 1���̳�Thread�ഴ���߳�
//        MyThread mythread = new MyThread();
//        // �����Զ����߳� start()�������Զ�����run()����
//        mythread.start();
//        // ��main���߳��д�ӡ��Ϣ
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName() + "ִ��ʱ��:" + new Date().getTime() + ";ִ�д�����" + i);
//        }

        // 2��ʵ��Runnable�ӿڴ����߳�
        // 2.1����main���̴߳�ӡ��Ϣ
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName() + "ִ��ʱ��:" + new Date().getTime() + ";ִ�д�����" + i);
//        }
//        // 2.2��ͨ��Thread��ִ��MyRunnable��
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable,"�ҵ�Runnable");
//        thread.start();

        // 3��ʵ��Callable�ӿڴ����߳�
        // 3.1������FutureTaskʵ�� ִ��MyCallable��
//        Callable callable;
//        FutureTask<String> task = new FutureTask<String>(new MyCallable());
//        // 3.2������Threadʵ����ִ��FutureTask
//        Thread thread = new Thread(task,"�ҵ�Callable");
//        thread.start();
//        // 3.3����main���̴߳�ӡ��Ϣ
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName() + "ִ��ʱ��:" + new Date().getTime() + ";ִ�д�����" + i);
//        }
//        // 3.4����ȡ����ӡCallable��ִ�н��
//        try {
//            String result = task.get();
//            System.out.println("MyCallable��ִ�н���ǣ�" + result);
//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//        }

        // 4��ͨ���̳߳�ִ��MyRunnable��
        // ������߰���10���̵߳��̳߳�
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 4.1��ͨ���̳߳�ִ���߳�
        executorService.execute(new MyRunnable());
        // 4.2����main���̴߳�ӡ��Ϣ
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "ִ��ʱ��:" + new Date().getTime() + ";ִ�д�����" + i);
        }
    }
}
