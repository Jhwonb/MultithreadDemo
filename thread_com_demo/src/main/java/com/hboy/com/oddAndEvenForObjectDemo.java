package com.hboy.com;

/**
 * @Title oddAndEvenDemo
 * @Description �߳�ͨ�� ʹ��Object��wait()��notify()����ʵ���̵߳Ļ��Ѽ�����
 * �߳�ͨ�ţ�ָ��������ϣ��cpu�������ǹ涨�Ĺ���ȥִ��ĳЩ�̣߳������̼߳����ҪЭ��ͨ���ˡ�
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/12 14:19
 * @Version 1.0.0
 */

public class oddAndEvenForObjectDemo {

    // Ҫ��ӡ������
    private int i = 0;
    private Object obj = new Object();

    /**
     * ������ӡ�������������̵߳���
     * @author houby
     * @return void
     * @date 2021/7/12 14:28
     */
    public void odd(){
            // �ж�i�Ƿ�С��10�����С��10����Ϊ����������д�ӡ
            while(i < 10) {
                synchronized (obj) {
                    if (i % 2 == 1) {
                        System.out.println("������" + i);
                        i++;
                        // ����ż���̴߳�ӡ
                        obj.notify();
                    } else {
                        try {
                            // �ȴ�ż���̴߳�ӡ���
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
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
            synchronized (obj) {
                if (i % 2 == 0) {
                    System.out.println("ż����" + i);
                    i++;
                    // ���������̴߳�ӡ
                    obj.notify();
                } else {
                    try {
                        // �ȴ������̴߳�ӡ���
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
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
