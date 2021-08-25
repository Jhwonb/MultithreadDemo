package com.hboy.mulitithread.creation;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Title CustomLock
 * @Description �Զ�����
 * @Author hboy
 * @Date 2021/7/9 15:07
 * @Version 1.0.0
 */

public class CustomLock{

    // ��ʶ������״̬ 0Ϊ������ 1Ϊ����
    volatile int state = 0;
    // ħ���ֱ࣬�Ӳ����ڴ� ��Ҫ���ڻ�ȡĳһ�����Ե��ڴ�ƫ����
    private static Unsafe unsafe = null;
    // state���ڴ�ƫ����
    private static long stateOffset;

    // ��ȡUnsafe���� ���������̶�д��
    static {
        Field singolnField = null;
        try {
            singolnField = Unsafe.class.getDeclaredField("theUnsafe");
            singolnField.setAccessible(true);
            unsafe = (Unsafe) singolnField.get(null);
            // ����
            stateOffset = unsafe.objectFieldOffset(CustomLock.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void lock(){
        while (!compareAndSet(0,1)){

        }

    }

    boolean compareAndSet(int OldVal, int newVal){
        // ���ͣ����this��stateOffset�����ֵΪ0�Ļ�����1����stateoffset����Ĳ�����Ȼ�󷵻�true�����򷵻�false��
        return unsafe.compareAndSwapInt(this,stateOffset,0,1);
    }

    void unlock(){
        state = 0;
    }

}
