package com.hboy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Title ReadWriteLockDemo
 * @Description ��д����Demo
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/22 15:55
 * @Version 1.0.0
 */

public class ReadWriteLockDemo {
    // ������Map����
    private Map<String, String> map = new HashMap<>();
    // ��д��
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // ��ȡ����
    private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    // ��ȡд��
    private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    // ����������
    public String  get(String key){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "�������Ѽ�������ʼ������...");
            // ���߳�˯��3s
            TimeUnit.SECONDS.sleep(3);
            return map.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            System.out.println(Thread.currentThread().getName() + "�������ѽ������������ѽ���...");
            readLock.unlock();
        }
    }

    public void put(String key, String value){
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "д�����Ѽ�������ʼд����...");
            TimeUnit.SECONDS.sleep(3);
            map.put(key,value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + "д�����ѽ�����д�����ѽ���...");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        readWriteLockDemo.put("key1","value1");
        new Thread("���߳�1"){
            public void run(){
                System.out.println(readWriteLockDemo.get("key1"));
            }
        }.start();
        new Thread("���߳�2"){
            public void run(){
                System.out.println(readWriteLockDemo.get("key1"));
            }
        }.start();
        new Thread("���߳�3"){
            public void run(){
                System.out.println(readWriteLockDemo.get("key1"));
            }
        }.start();
    }
}
