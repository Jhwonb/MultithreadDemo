package com.hboy.com;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Title cyclicBarrierDemo
 * @Description
 * CyclicBarrier��ʵ����һ���̵߳ȴ���ĳ��״̬֮����ȫ��ִ�� �ײ���ʹ��ReentranLock��Conditionʵ�ֵ�
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/12 15:51
 * @Version 1.0.0
 */

public class CyclicBarrierDemo {

    // �����ǲ���CyclicBarrier���߳���
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public void startThread(){
        // ��ȡ��ǰ�̵߳�����
        String name = Thread.currentThread().getName();
        System.out.println(name + "����׼��...");
        // ����CyclicBarrier��await�����ȴ��߳�ȫ��ִ�����
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ��ӡ�߳������ɹ�����Ϣ ��ӡʱ���������һ���߳��Ƿ���ͬʱ����
        System.out.println(name + "�Ѿ�������ϣ�" + new Date().getTime());
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
