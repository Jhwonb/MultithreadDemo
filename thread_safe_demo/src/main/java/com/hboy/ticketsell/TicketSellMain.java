package com.hboy.ticketsell;

/**
 * @Title TicketSellMain
 * @Description ������ӰƱ��main����
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/10 17:10
 * @Version 1.0.0
 */

public class TicketSellMain {
    public static void main(String[] args) {
        // ����һ��������ӰƱ�Ķ���
        TicketSell ticket = new TicketSell();
        // ����һ���߳�
        Thread thread = new Thread(ticket,"����1");
        Thread thread2 = new Thread(ticket,"����2");
        Thread thread3 = new Thread(ticket,"����3");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
