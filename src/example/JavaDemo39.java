
class MyThread implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        // while (true) { // 每一次只允许一个线程进行访问
        // synchronized (this) {
        // if (this.ticket > 0) {
        // try { // 模拟网络延迟
        // Thread.sleep(100);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // System.out.println(Thread.currentThread().getName() + "卖票、ticket=" +
        // this.ticket--);
        // } else {
        // System.out.println("票卖光了");
        // break;
        // }
        // }
        // }
        this.sellTicket();
    }

    private synchronized void sellTicket() {
        while (true) { // 每一次只允许一个线程进行访问
            if (this.ticket > 0) {
                try { // 模拟网络延迟
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票、ticket=" + this.ticket--);
            } else {
                System.out.println("票卖光了");
                break;
            }
        }
    }
}

public class JavaDemo39 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt, "卖票员A").start();
        new Thread(mt, "卖票员B").start();
        new Thread(mt, "卖票员C").start();
        // 卖票员A卖票、ticket=10
        // 卖票员A卖票、ticket=9
        // 卖票员A卖票、ticket=8
        // 卖票员A卖票、ticket=7
        // 卖票员A卖票、ticket=6
        // 卖票员A卖票、ticket=5
        // 卖票员A卖票、ticket=4
        // 卖票员A卖票、ticket=3
        // 卖票员A卖票、ticket=2
        // 卖票员A卖票、ticket=1
        // 票卖光了
        // 票卖光了
        // 票卖光了
    }
}