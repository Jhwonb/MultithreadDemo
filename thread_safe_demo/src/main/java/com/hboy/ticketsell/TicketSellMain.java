package com.hboy.ticketsell;

/**
 * @Title TicketSellMain
 * @Description 售卖电影票的main方法
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/10 17:10
 * @Version 1.0.0
 */

public class TicketSellMain {
    public static void main(String[] args) {
        // 创建一个售卖电影票的对象
        TicketSell ticket = new TicketSell();
        // 创建一个线程
        Thread thread = new Thread(ticket,"窗口1");
        Thread thread2 = new Thread(ticket,"窗口2");
        Thread thread3 = new Thread(ticket,"窗口3");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
