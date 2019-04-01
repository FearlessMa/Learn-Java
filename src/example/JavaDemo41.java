
public class JavaDemo41 {
    public static Boolean flag = true;

    public static void main(String[] args) throws Exception {
        // new Thread(() -> {
        // int num = 0;
        // while (flag) {
        // try {
        // Thread.sleep(50);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // System.out.println(Thread.currentThread().getName() + "、num=" + num++);
        // }
        // }).start();
        // Thread.sleep(200);
        // flag = false;
        // Thread-0、num=0
        // Thread-0、num=1
        // Thread-0、num=2
        // Thread-0、num=3

        Thread userThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "、i= " + i);
            }
        }, "用户线程");
        Thread daemonThread = new Thread(() -> {
            // 设置循环次数为 int 最大值
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "、i= " + i);
            }
        }, "守护线程");
        daemonThread.setDaemon(true);// 设置守护线程
        userThread.start();
        daemonThread.start();
        //守护线程不会执行到 int最大值才结束，而是被守护线程结束后，守护线程也结束
        // 守护线程、i= 0
        // 用户线程、i= 0
        // 用户线程、i= 1
        // 守护线程、i= 1
        // 守护线程、i= 2
        // 用户线程、i= 2
        // 守护线程、i= 3
        // 用户线程、i= 3
        // 守护线程、i= 4
        // 用户线程、i= 4

    }
}