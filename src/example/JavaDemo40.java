class Message {
    private String title;
    private String content;
    private Boolean flag = true;

    // flag = true 可以生产 ，不可以消费 ，false 可以消费，不可生产
    public synchronized void set(String title, String content) {
        if (!this.flag) {
            try {
                super.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        this.title = title;
        this.content = content;
        this.flag = false;
        super.notify();
    }

    public synchronized String get() {
        if (this.flag) {
            try {
                super.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            return this.title + " - " + this.content;
        } finally {
            this.flag = true;
            super.notify();
        }
    }

}

class Producter implements Runnable {
    private Message msg;

    public Producter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        // try {
        // Thread.sleep(300);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                this.msg.set("张三", "我是张三");
            } else {
                this.msg.set("李四", "我是李四");
            }
        }
    }
}

class Consumer implements Runnable {
    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.msg.get());
        }
    }
}

public class JavaDemo40 {
    public static void main(String[] args) {
        Message msg = new Message();
        Runnable p = new Producter(msg);
        Runnable c = new Consumer(msg);
        new Thread(p).start();
        new Thread(c).start();

    }
}