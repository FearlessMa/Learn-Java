
class MyThread implements Runnable { // 线程的主体类
    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() { // 线程的主体方法
        // super.run();
        for (int i = 0; i < 5; i++) {
            System.out.println(this.title + "i=" + i);
        }
    }
}

// @FunctionalInterface //jdk1.8之后就变为了函数式接口
// public interface Runnable{
// @Override
// public void run();
// }

public class JavaDemo35 {
    public static void main(String[] args) {
        // new Thread(new MyThread("线程A")).start();
        // new Thread(new MyThread("线程B")).start();
        // new Thread(new MyThread("线程C")).start();
        // 线程Bi=0
        // 线程Bi=1
        // 线程Ci=0
        // 线程Ai=0
        // 线程Ai=1
        // 线程Ci=1
        // 线程Bi=2
        // 线程Ci=2
        // 线程Ci=3
        // 线程Ai=2
        // 线程Ci=4
        // 线程Bi=3
        // 线程Ai=3
        // 线程Bi=4
        // 线程Ai=4
        for (int x = 0; x < 3; x++) {
            String title = "线程-" + x;
            Runnable rn = new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(title + "i=" + i);
                    }
                }
            };
            new Thread(rn).start();
        }
        // 线程-1i=0
        // 线程-1i=1
        // 线程-1i=2
        // 线程-2i=0
        // 线程-0i=0
        // 线程-2i=1
        // 线程-2i=2
        // 线程-1i=3
        // 线程-2i=3
        // 线程-0i=1
        // 线程-2i=4
        // 线程-1i=4
        // 线程-0i=2
        // 线程-0i=3
        // 线程-0i=4
    }
}