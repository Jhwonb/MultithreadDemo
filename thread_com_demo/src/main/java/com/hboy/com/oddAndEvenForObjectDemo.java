package com.hboy.com;

/**
 * @Title oddAndEvenDemo
 * @Description 线程通信 使用Object的wait()、notify()方法实现线程的唤醒及休眠
 * 线程通信：指的是我们希望cpu按照我们规定的规律去执行某些线程，所以线程间就需要协调通信了。
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/12 14:19
 * @Version 1.0.0
 */

public class oddAndEvenForObjectDemo {

    // 要打印的数字
    private int i = 0;
    private Object obj = new Object();

    /**
     * 奇数打印方法，由奇数线程调用
     * @author houby
     * @return void
     * @date 2021/7/12 14:28
     */
    public void odd(){
            // 判断i是否小于10，如果小于10，且为奇数，则进行打印
            while(i < 10) {
                synchronized (obj) {
                    if (i % 2 == 1) {
                        System.out.println("奇数：" + i);
                        i++;
                        // 唤醒偶数线程打印
                        obj.notify();
                    } else {
                        try {
                            // 等待偶数线程打印完毕
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    }

    /**
     * 偶数打印方法，由偶数线程调用
     * @author houby
     * @return void
     * @date 2021/7/12 14:28
     */
    public void even(){
        // 判断i是否小于10，如果小于10，且为偶数，则进行打印
        while (i < 10) {
            synchronized (obj) {
                if (i % 2 == 0) {
                    System.out.println("偶数：" + i);
                    i++;
                    // 唤醒奇数线程打印
                    obj.notify();
                } else {
                    try {
                        // 等待奇数线程打印完毕
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
        // 开启奇数线程打印
        Thread oddThread = new Thread(new Runnable() {
            public void run() {
                oddEven.odd();
            }
        });
        // 开启偶数线程打印
        Thread evenThread = new Thread(new Runnable() {
            public void run() {
                oddEven.even();
            }
        });

        oddThread.start();
        evenThread.start();
    }

}
