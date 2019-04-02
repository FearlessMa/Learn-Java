
class Producter implements Runnable {
    private Box box;

    public Producter(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            this.box.setComp();
            System.out.println("生产电脑" + "、已经生产了" + box.getCount());
            if (box.getCount() == 10) {
                return;
            }
        }
    }
}

class Consumer implements Runnable {
    private Box box;

    public Consumer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            this.box.getComp();
            System.out.println("搬运电脑");
            if (box.getCount() == 10) {
                return;
            }
        }
    }
}

class Box {
    private static int count;
    public static Boolean flag = false;
    private Computer comp;

    class Computer {
        private String name;

        public Computer(int name) {
            this.name = "comp-" + (name + 1);
            Box.count += 1;
        }

        public String getName() {
            return name;
        }
    }

    public synchronized void setComp() {
        if (flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
            }
        }
        this.comp = new Computer(Box.count);
        flag = true;
        super.notifyAll();
    }

    public synchronized Computer getComp() {
        if (!flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
            }
        }
        flag = false;
        super.notifyAll();
        System.out.println("当前搬运的电脑是" + this.comp.getName());
        return this.comp;
    }

    public int getCount() {
        return Box.count;
    }

}

public class JavaDemo43 {
    public static void main(String[] args) {
        Box box = new Box();
        Runnable pro = new Producter(box);
        Runnable con = new Consumer(box);
        new Thread(pro, "生产线程").start();
        new Thread(con, "搬运线程").start();
    }
}