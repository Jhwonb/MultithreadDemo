package com.hboy.com;

import java.util.concurrent.CountDownLatch;

/**
 * @Title CoahRacerDemo
 * @Description �߳�ͨ�� ʹ��CountDownLatch���� ʵ���̵߳Ļ��Ѽ�����
 * CountDownLatch:ָ�����߳�A�ȴ����ɸ��߳�ִ����Ϻ�����ִ��
 * ʵ�����󣺵������˶�Ա����֮�󣬽����ŷ������ʼѵ��
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/12 15:12
 * @Version 1.0.0
 */


public class CoahRacerDemo {

    // ����Ҫ�ȴ����˶�ԱΪ3��
    private CountDownLatch countDownLatch = new CountDownLatch(3);

    // �˶�Ա���������˶�Ա�̵߳���
    public void racer(){
        // ��ȡ��ǰ�˶�Ա������
        String name = Thread.currentThread().getName();
        // �˶�Ա��ʼ׼�� ��ӡ
        System.out.println("�˶�Ա��" + name + "����׼��...");
        // ���˶�Ա˯��1s ��ʶ�˶�Ա��׼��
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("�˶�Ա��" + name + "׼����ϡ�");
        // ִ�м�����һ����
        countDownLatch.countDown();
    }

    // �����������ɽ����̵߳���
    public void coach(){
        // ��ȡ��������
        String name = Thread.currentThread().getName();
        // �����ȴ����е��˶�Ա׼�����
        System.out.println(name + "�ȴ��˶�Ա׼��...");
        // ����CountDownLatch��wait�����ȴ������߳�׼�����
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // �����˶�Ա�Ѿ�׼��������������ʼѵ��
        System.out.println("�����˶�Ա�Ѿ�׼��������" + name + "��ʼѵ����");

    }

    public static void main(String[] args) {
        final CoahRacerDemo coahRacerDemo = new CoahRacerDemo();
        Thread threadRacer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                coahRacerDemo.racer();
            }
        },"�˶�Ա1");
        Thread threadRacer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                coahRacerDemo.racer();
            }
        },"�˶�Ա2");
        Thread threadRacer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                coahRacerDemo.racer();
            }
        },"�˶�Ա3");
        Thread threadCoach = new Thread(new Runnable() {
            @Override
            public void run() {
                coahRacerDemo.coach();
            }
        },"����");
        threadCoach.start();
        threadRacer1.start();
        threadRacer2.start();
        threadRacer3.start();
    }
}
