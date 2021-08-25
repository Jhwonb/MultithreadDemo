package com.hboy.com;

import java.util.concurrent.Semaphore;

/**
 * @Title WorkerMachineDemo
 * @Description Semaphore�����ڿ��ƶ�ĳ����Դ�Ŀ���Ȩ��
 * ��ǰ������һ����8�����ˣ�3̨����������Ϊ������Դ����ÿ��ֻ����һ����ʹ�ã�
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/12 15:59
 * @Version 1.0.0
 */

public class WorkerMachineDemo {

    static class Work implements Runnable {
        // ���˵Ĺ���
        private int workerNum;
        // ��������
        private Semaphore semaphore;

        public Work(int workerNum, Semaphore semaphore) {
            this.workerNum = workerNum;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                // ���˻�ȡ����
                semaphore.acquire();
                // ��ӡ���˻�ȡ���������ҿ�ʼ����
                String name = Thread.currentThread().getName();
                System.out.println(name + "��ȡ����������ʼ������");
                // �߳�˯��1s��ģ�⹤��ʹ�û���
                Thread.sleep(1000);
                // ʹ����ϣ��ͷŻ�������ӡʹ����ϵ���Ϣ
                semaphore.release();
                System.out.println(name + "ʹ����ϣ��ͷŻ�����");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // ��������
        int works = 8;
        // ��������
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < works; i++) {
            new Thread(new Work(i,semaphore)).start();
        }
    }

}
