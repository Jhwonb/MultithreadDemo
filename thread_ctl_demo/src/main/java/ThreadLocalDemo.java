/**
 * @Title ThreadLocalDemo
 * @Description
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/13 11:26
 * @Version 1.0.0
 */

public class ThreadLocalDemo {

    // �������ж���Ǯ��ȡ����
    static class Bank {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
            protected Integer initialValue(){
                return 0;
            }
        };

        // ȡǮ
        public Integer get(){
            return threadLocal.get();
        }

        // ��Ǯ
        public void set(Integer money){
            threadLocal.set(threadLocal.get() + money);
        }
    }
    // ����ת�˶��󣺴�������ȡǮ��ת�ˣ����浽�˻�
    static class Transfer implements Runnable{

        private Bank bank;
        public Transfer(Bank bank){
            this.bank = bank;
        }
        @Override
        public void run() {
            for(int i = 0;i<10;i++){
                bank.set(10);
                System.out.println(Thread.currentThread().getName() + "�˻���" + bank.get());
            }

        }
    }
    // ��main��ʹ�������������ģ��ת��
    public static void main(String[] args) {
        Bank bank = new Bank();
        Transfer transfer = new Transfer(bank);
        Thread thread1 = new Thread(transfer,"�ͻ�1");
        Thread thread2 = new Thread(transfer,"�ͻ�2");
        thread1.start();
        thread2.start();
    }
}
