package chapter0;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class example {

  public static void main(String[] args) {
    // int a = 1;
    // Integer b = 2;
    // int c = b;
    // Integer d = a;
    // System.out.println(a);
    // System.out.println(b);
    // System.out.println(c);
    // System.out.println(d);
    // Message msg = new Message();
    // msg.send();

    // Message parent = new Message();

    // System.out.println(Message.class);
    // parent.toString();
    int[] arr = { 1, 2, 3 };
    List list = Arrays.asList(arr);
    for (Object item : list) {
      System.out.println(item);
    }
  }
}

interface IMessage {
  public void send();
}

abstract class AMessage implements IMessage {
  @Override
  public abstract void send();
}

class Parent extends AMessage {
  @Override
  public void send() {
    System.out.println("parent message is send");
  }

  @Override
  public String toString() {
    String str = this.getClass().getName();
    System.out.println("1234");
    return str;
  }
}

class Message extends Parent {
  @Override
  public void send() {
    System.out.println("message is send");
  }
}