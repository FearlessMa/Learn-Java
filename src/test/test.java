//  多线程加减法，生产者消费者 模式
package test;

class AddThread implements Runnable {
  private Resource resource;

  AddThread(Resource resource) {
    this.resource = resource;
  }

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      try {
        this.resource.add();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}

class SubThread implements Runnable {
  Resource resource;

  SubThread(Resource resource) {
    this.resource = resource;
  }

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      try {
        this.resource.sub();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}

class Resource {
  private volatile int num = 0;
  private volatile boolean flag = true; // true可以增加 不可减少

  Resource() {
  }

  public synchronized void add() throws InterruptedException {
    Thread.sleep(200);
    if (this.flag == false || this.num != 0) {
      super.wait();
    }
    this.num++;
    this.flag = false;
    System.out.println(Thread.currentThread().getName() + "线程，num=" + this.num);
    super.notifyAll();
  }

  public synchronized void sub() throws InterruptedException {
    Thread.sleep(100);
    if (this.flag == true || this.num != 1) {
      super.wait();
    }
    this.num--;
    this.flag = true;
    System.out.println(Thread.currentThread().getName() + "线程，num=" + this.num);
    this.notifyAll();
  }
}

public class test {

  public static void main(String[] args) {
    Resource res = new Resource();
    AddThread ad = new AddThread(res);
    SubThread su = new SubThread(res);
    new Thread(ad, "线程A").start();
    new Thread(ad, "线程B").start();
    new Thread(ad, "线程c").start();
    new Thread(su, "线程z").start();
    new Thread(su, "线程X").start();
    new Thread(su, "线程Y").start();
  }
}