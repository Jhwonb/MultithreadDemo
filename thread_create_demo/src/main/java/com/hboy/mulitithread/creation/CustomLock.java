package com.hboy.mulitithread.creation;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Title CustomLock
 * @Description 自定义锁
 * @Author hboy
 * @Date 2021/7/9 15:07
 * @Version 1.0.0
 */

public class CustomLock{

    // 标识该锁的状态 0为自由锁 1为上锁
    volatile int state = 0;
    // 魔法类，直接操作内存 主要用于获取某一个属性的内存偏移量
    private static Unsafe unsafe = null;
    // state的内存偏移量
    private static long stateOffset;

    // 获取Unsafe对象 可以用做固定写法
    static {
        Field singolnField = null;
        try {
            singolnField = Unsafe.class.getDeclaredField("theUnsafe");
            singolnField.setAccessible(true);
            unsafe = (Unsafe) singolnField.get(null);
            // 根据
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
        // 解释：如果this中stateOffset代表的值为0的话，则将1赋给stateoffset代表的参数，然后返回true。否则返回false。
        return unsafe.compareAndSwapInt(this,stateOffset,0,1);
    }

    void unlock(){
        state = 0;
    }

}
