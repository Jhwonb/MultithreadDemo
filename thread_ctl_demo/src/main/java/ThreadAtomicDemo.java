import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Title ThreadAtomicDemo
 * @Description ԭ�������ʾ��CAS����
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/16 16:34
 * @Version 1.0.0
 */

public class ThreadAtomicDemo {
    // ִ��n++�����ı���
//    private static AtomicInteger n = new AtomicInteger(0);
    // Ϊ�˽��cas��ABA���⣬��Ҫʹ��AtomicReference��
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
                            // ��ȡʱ���
                            stmp = n.getStamp();
                            // ��ȡԤ��ֵ
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
                            // ��ȡʱ���
                            stmp = n.getStamp();
                            // ��ȡԤ��ֵ
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
            System.out.println("n������ֵΪ��" + n.getReference());
        }
    }
}
