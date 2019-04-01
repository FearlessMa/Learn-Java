
class Num {
    private int num;
    private Boolean flag = true;// true 加法，false减法

    public synchronized void increment() {
        if (!this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {

            }
        }
        this.num++;
        System.out.println("增加后num=" + this.num);
        this.flag = false;
        super.notifyAll();
    }

    public synchronized void decrement() {
        if (this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {

            }
        }
        this.num--;
        System.out.println("减少后num=" + this.num);
        this.flag = true;
        super.notifyAll();
    }

    public int getNum() {
        return num;
    }
}

class Increment implements Runnable {
    private Num num;

    public Increment(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        this.num.increment();
        System.out.println(Thread.currentThread().getName() + "、num=" + this.num.getNum());
    }
}

class Decrement implements Runnable {
    private Num num;

    public Decrement(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        this.num.decrement();
        System.out.println(Thread.currentThread().getName() + "、num=" + this.num.getNum());
    }
}

public class JavaDemo42 {
    public static void main(String[] args) throws InterruptedException {
        Num num = new Num();
        Thread t1 = new Thread(new Increment(num), "增加线程A");
        Thread t2 = new Thread(new Increment(num), "增加线程B");
        Thread t3 = new Thread(new Decrement(num), "减法线程A");
        Thread t4 = new Thread(new Decrement(num), "减法线程B");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.sleep(300);
        System.out.println(num.getNum());
    }
}