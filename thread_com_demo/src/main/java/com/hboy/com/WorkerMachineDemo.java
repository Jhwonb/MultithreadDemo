package com.hboy.com;

import java.util.concurrent.Semaphore;

/**
 * @Title WorkerMachineDemo
 * @Description Semaphore：用于控制对某组资源的控制权限
 * 当前场景：一共有8个工人，3台机器，机器为互斥资源（即每次只能由一个人使用）
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/12 15:59
 * @Version 1.0.0
 */

public class WorkerMachineDemo {

    static class Work implements Runnable {
        // 工人的工号
        private int workerNum;
        // 机器数量
        private Semaphore semaphore;

        public Work(int workerNum, Semaphore semaphore) {
            this.workerNum = workerNum;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                // 工人获取机器
                semaphore.acquire();
                // 打印工人获取到机器并且开始工作
                String name = Thread.currentThread().getName();
                System.out.println(name + "获取到机器，开始工作。");
                // 线程睡眠1s，模拟工人使用机器
                Thread.sleep(1000);
                // 使用完毕，释放机器，打印使用完毕的信息
                semaphore.release();
                System.out.println(name + "使用完毕，释放机器。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 工人数量
        int works = 8;
        // 机器数量
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < works; i++) {
            new Thread(new Work(i,semaphore)).start();
        }
    }

}
