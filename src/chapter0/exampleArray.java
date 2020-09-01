package chapter0;

public class exampleArray {

  public static void main(String[] args) {
    String[] arr = new String[3];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = ((Integer) i).toString();
    }
    for (String item : arr) {
      System.out.println(item);
    }
  }

}