package com.hboy;

/**
 * @Title DeadLockRunnable
 * @Description
 * @Company hjsj
 * @Author hboy
 * @Date 2021/5/11 14:56
 * @Version 1.0.0
 */

public class DeadLockRunnable implements Runnable{
    // 决定线程走向的一个标识
    private int flag;
    // 锁对象1
    private static Object obj1 = new Object();
    // 锁对象2
    private static Object obj2 = new Object();

    public DeadLockRunnable(int flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag == 1){
            // 线程1执行的代码
            synchronized (obj1){
                System.out.println(Thread.currentThread().getName() + "已获取到obj1，正在获取obj2！");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName() + "已获取到obj1和obj2！");
                }
            }
        }else{
            // 线程2执行的代码
            synchronized (obj2){
                System.out.println(Thread.currentThread().getName() + "已获取到obj2，正在获取obj1！");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName() + "已获取到obj1和obj2！");
                }
            }
        }
    }
}
