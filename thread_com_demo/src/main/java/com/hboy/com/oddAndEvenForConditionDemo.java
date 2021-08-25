package com.hboy.com;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title oddAndEvenForCondationDemo
 * @Description �߳�ͨ�� ʹ��Condition��await()��signal()���� ʵ���̵߳Ļ��Ѽ�����
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/12 14:53
 * @Version 1.0.0
 */

public class oddAndEvenForConditionDemo {
    private int i = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * ������ӡ�������������̵߳���
     * @author houby
     * @return void
     * @date 2021/7/12 14:28
     */
    public void odd(){
        // �ж�i�Ƿ�С��10�����С��10����Ϊ����������д�ӡ
        while(i < 10) {
            lock.lock();
            try {
                if (i % 2 == 1) {
                    System.out.println("������" + i);
                    i++;
                    // ����ż���̴߳�ӡ
                    condition.signal();
                } else {
                    try {
                        // �ȴ�ż���̴߳�ӡ���
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }

    /**
     * ż����ӡ��������ż���̵߳���
     * @author houby
     * @return void
     * @date 2021/7/12 14:28
     */
    public void even(){
        // �ж�i�Ƿ�С��10�����С��10����Ϊż��������д�ӡ
        while (i < 10) {
            lock.lock();
            try {
                if (i % 2 == 0) {
                    System.out.println("ż����" + i);
                    i++;
                    // ���������̴߳�ӡ
                    condition.signal();
                } else {
                    try {
                        // �ȴ������̴߳�ӡ���
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        final oddAndEvenForObjectDemo oddEven = new oddAndEvenForObjectDemo();
        // ���������̴߳�ӡ
        Thread oddThread = new Thread(new Runnable() {
            public void run() {
                oddEven.odd();
            }
        });
        // ����ż���̴߳�ӡ
        Thread evenThread = new Thread(new Runnable() {
            public void run() {
                oddEven.even();
            }
        });

        oddThread.start();
        evenThread.start();
    }

}
