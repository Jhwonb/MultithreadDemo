import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Title ThreadAtomicDemo
 * @Description 原子类的演示，CAS操作
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/16 16:34
 * @Version 1.0.0
 */

public class ThreadAtomicDemo {
    // 执行n++操作的变量
//    private static AtomicInteger n = new AtomicInteger(0);
    // 为了解决cas的ABA问题，需要使用AtomicReference类
    private static AtomicStampedReference<Integer> n;

    public static void main(String[] args) throws InterruptedException {
        int j = 0;
        while (j < 100){
            n = new AtomicStampedReference<>(0, 0);
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++){
                        int stmp;
                        Integer reference;
                        do{
                            // 获取时间戳
                            stmp = n.getStamp();
                            // 获取预期值
                            reference = n.getReference();
                        } while (!n.compareAndSet(reference, reference + 1, stmp, stmp + 1));
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++){
//                        n.getAndIncrement();
                        int stmp;
                        Integer reference;
                        do{
                            // 获取时间戳
                            stmp = n.getStamp();
                            // 获取预期值
                            reference = n.getReference();
                        } while (!n.compareAndSet(reference, reference + 1, stmp, stmp + 1));
                    }
                }
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            j++;
            System.out.println("n的最终值为：" + n.getReference());
        }
    }
}
