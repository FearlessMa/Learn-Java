package chapter0;

import java.util.ArrayList;

public class exampleList {
  public static void main(String[] args) {
    ArrayList<Object> arrList = new ArrayList<Object>();
    arrList.add(1);
    arrList.add("2");
    arrList.add("3");
    arrList.add(4);
    for (Object item : arrList) {
      System.out.println(item);
    }
    // 获取指定index值
    Object a = arrList.get(0);
    System.out.println(a);

  }
}