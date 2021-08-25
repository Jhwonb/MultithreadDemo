import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title ReentrantLockDemo
 * @Description
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/27 10:18
 * @Version 1.0.0
 */

public class ReentrantLockDemo {

    private void test1(){
        Object obj = new Object();
        synchronized (obj){
            System.out.println("方法1");
        }
    }
    private void test2(){
        Object obj = new Object();
        System.out.println("方法2");
    }

    private void test3(){
        synchronized (ReentrantLockDemo.class){
            for(int i = 0; i < 1000; i++){
                System.out.println("输出" + i);
            }
        }
    }
    private void test4(){
        for(int i = 0; i < 1000; i++){
            synchronized (ReentrantLockDemo.class){
                System.out.println("输出" + i);
            }
        }
    }

    private static ReentrantLock lock = new ReentrantLock(true);

    private static void test() throws InterruptedException {
        Thread thread0 = new Thread(()->{
            lock.lock();
            try {
                System.out.println("t0");
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t0");

        Thread thread1 = new Thread(()->{
            lock.lock();
            try {
                System.out.println("t1");
            }finally {
                lock.unlock();
            }
        },"t1");

        Thread thread2 = new Thread(()->{
            lock.lock();
            try {
                System.out.println("t2");
            }finally {
                lock.unlock();
            }
        },"t2");
        thread0.start();
        Thread.sleep(20);
        thread1.start();
        Thread.sleep(20);
        thread2.start();

    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }

}
