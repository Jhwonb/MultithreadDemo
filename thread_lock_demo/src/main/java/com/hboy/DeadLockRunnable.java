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
    // �����߳������һ����ʶ
    private int flag;
    // ������1
    private static Object obj1 = new Object();
    // ������2
    private static Object obj2 = new Object();

    public DeadLockRunnable(int flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag == 1){
            // �߳�1ִ�еĴ���
            synchronized (obj1){
                System.out.println(Thread.currentThread().getName() + "�ѻ�ȡ��obj1�����ڻ�ȡobj2��");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName() + "�ѻ�ȡ��obj1��obj2��");
                }
            }
        }else{
            // �߳�2ִ�еĴ���
            synchronized (obj2){
                System.out.println(Thread.currentThread().getName() + "�ѻ�ȡ��obj2�����ڻ�ȡobj1��");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName() + "�ѻ�ȡ��obj1��obj2��");
                }
            }
        }
    }
}
