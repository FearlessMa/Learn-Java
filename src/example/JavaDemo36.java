import java.util.concurrent.*;

// class MyThread implements Runnable {
//     private int ticket = 5;

//     @Override
//     public void run() {
//         for (int i = 0; i < 100; i++) {
//             if (this.ticket > 0) {
//                 System.out.println("卖票,ticket=" + this.ticket--);
//             }
//         }
//     }
// }

class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "线程执行完毕 ";
    }
}

public class JavaDemo36 {
    public static void main(String[] args) {
        FutureTask<String> f = new FutureTask<>(new MyThread());
        new Thread(f).start();
        try {
            System.out.println(f.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Runnable mt = new MyThread();
        // new Thread(mt).start();
        // new Thread(mt).start();
        // new Thread(mt).start();
        // 卖票,ticket=3
        // 卖票,ticket=4
        // 卖票,ticket=5
        // 卖票,ticket=1
        // 卖票,ticket=2
    }
}