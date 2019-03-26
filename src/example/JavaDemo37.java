
class MyThread implements Runnable {
    private static int num;

    private static void incrementNum() {
        MyThread.num += 1;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        MyThread.incrementNum();
        Thread.currentThread().setName("name" + MyThread.num);
        // 获取当前线程的名字
        System.out.println(Thread.currentThread().getName());
    }
}

public class JavaDemo37 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        // new Thread(mt, "线程A").start();
        // new Thread(mt).start();
        // new Thread(mt, "线程B").start();
        // mt.run();// main
        // 线程A
        // 线程B
        // Thread-0

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "i=" + i);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "线程对象").start();
        // 线程对象i=0
        // 线程对象i=1
        // 线程对象i=2
        // 线程对象i=3
        // 线程对象i=4
        // 线程对象i=5
        // 线程对象i=6
        // 线程对象i=7
        // 线程对象i=8
        // 线程对象i=9
    }
}