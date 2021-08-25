package com.hboy.ticketsell;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title ticket
 * @Description
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/10 17:06
 * @Version 1.0.0
 */

public class TicketSell implements Runnable {

    // ��ӰƱ��������
    private int ticketNum = 100;
    private Object obj = new Object();
    // ������
    // ����Ϊ�Ƿ�Ϊ��ƽ���� true��Ϊ��ƽ���������̶߳�ӵ��ִ��Ȩ false:�ǹ�ƽ������ռ��
    private Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            // ����̰߳�ȫ����
            // 1��ͬ�������
//            synchronized (obj){
//                if (ticketNum > 0) {
//                    // �����߳�˯��100ms
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    // ��ӡʣ���ӰƱ�����������ҵ�ӰƱ��һ
//                    String name = Thread.currentThread().getName();
//                    System.out.println("�߳�" + name + "ʣ���ӰƱ��" + ticketNum--);
//                }
//            }

            // 2��ͬ������
//            saleTicket();

            // 3��ͬ����
            // ��ͬ����
            lock.lock();
            try {
                if (ticketNum > 0) {
                    // �����߳�˯��100ms
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // ��ӡʣ���ӰƱ�����������ҵ�ӰƱ��һ
                    String name = Thread.currentThread().getName();
                    System.out.println("�߳�" + name + "ʣ���ӰƱ��" + ticketNum--);
                }
            }finally {
                // �ͷ�ͬ����
                lock.unlock();
            }
        }
    }

    /**
     * 2��ͬ����������̰߳�ȫ����
     * ע������static���� ����synchronized(TicketSell.class)�������ڷ�static���� ����synchronized(this)
     * */
    private synchronized void saleTicket(){
        if (ticketNum > 0) {
            // �����߳�˯��100ms
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // ��ӡʣ���ӰƱ�����������ҵ�ӰƱ��һ
            String name = Thread.currentThread().getName();
            System.out.println("�߳�" + name + "ʣ���ӰƱ��" + ticketNum--);
        }
    }
}
