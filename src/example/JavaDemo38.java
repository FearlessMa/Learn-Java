
public class JavaDemo38 {
    public static void main(String[] args) {
        // Thread t = new Thread(() -> {
        // System.out.println("线程执行中");
        // try {
        // Thread.sleep(3000);
        // } catch (InterruptedException e) {
        // System.out.println(e);
        // e.printStackTrace();
        // System.out.println("线程被中断");
        // }
        // }, "线程t");
        // t.start();
        // if (!t.isInterrupted()) {
        // t.interrupt();
        // }
        // System.out.println(t.getName() + "是否被中断" + t.isInterrupted());
        // 线程执行中
        // java.lang.InterruptedException: sleep interrupted
        // 线程被中断
        // 线程t是否被中断true
        // Thread mainThread = Thread.currentThread();
        // Thread td = new Thread(() -> {
        // for (int i = 0; i < 5; i++) {
        // if (i != 0) {
        // Thread.yield();
        // System.out.println("yield被执行");
        // }
        // // if (i == 1) {
        // // try {
        // // mainThread.join();
        // // } catch (InterruptedException e) {

        // // }
        // // }
        // System.out.println(Thread.currentThread().getName() + "、i=" + i);
        // }
        // }, "子线程");
        // td.start();
        // for (int i = 0; i < 5; i++) {
        // System.out.println(Thread.currentThread().getName() + "、i=" + i);
        // }
        // 子线程、i=0
        // main、i=0
        // yield被执行
        // main、i=1
        // main、i=2
        // 子线程、i=1
        // main、i=3
        // yield被执行
        // 子线程、i=2
        // main、i=4
        // yield被执行
        // 子线程、i=3
        // yield被执行
        // 子线程、i=4
        /********************** 强制执行结果 */
        // main、i=0
        // 子线程、i=0
        // main、i=1
        // main、i=2
        // main、i=3
        // main、i=4
        // 子线程、i=1
        // 子线程、i=2
        // 子线程、i=3
        // 子线程、i=4

        // ******************没有强制执行的结果 */
        // 子线程、i=0
        // main、i=0
        // 子线程、i=1
        // main、i=1
        // 子线程、i=2
        // main、i=2
        // 子线程、i=3
        // main、i=3
        // 子线程、i=4
        // main、i=4

        Runnable run = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "、i=" + i);
            }
        };
        Thread t1 = new Thread(run, "线程1");
        Thread t2 = new Thread(run, "线程2");
        Thread t3 = new Thread(run, "线程3");
        t1.setPriority(Thread.MAX_PRIORITY);// 最高
        t2.setPriority(Thread.NORM_PRIORITY);// 正常
        t3.setPriority(Thread.MIN_PRIORITY);// 最低
        t1.start();
        t2.start();
        t3.start();

    }
}