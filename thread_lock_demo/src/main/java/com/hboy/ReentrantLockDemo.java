package com.hboy;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title ReentrantLockDemo
 * @Description ����������Demo
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/22 15:48
 * @Version 1.0.0
 */

public class ReentrantLockDemo {
    public static void main(String[] args) {
        // ���������������߳��������Ѿ�ӵ�е���ʱ�����������������ٴ��õ�ͬһ����
        // �����������Ѿ�ӵ�����Ķ�������ظ���ӵ�и���
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            lock.lock();
            System.out.println("����������" + (i+1));
        }
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("����������" + (i+1));
            }finally {
                lock.unlock();
            }
        }
    }
}
