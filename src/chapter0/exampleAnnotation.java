package chapter0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class exampleAnnotation {

  public static void main(String[] args) throws Exception {
    Class clazz = Class.forName("chapter0.Test");
    Method methods[] = clazz.getDeclaredMethods();
    for (Method method : methods) {
      System.out.println(method);
      boolean isAnnotation = method.isAnnotationPresent(Writer.class);
      if (isAnnotation) {
        Writer writerAnno = method.getAnnotation(Writer.class);
        System.out.println("name = " + writerAnno.name());
        System.out.println("age = " + writerAnno.age());
      }
    }

    boolean isTestAnno = clazz.isAnnotationPresent(Writer.class);
    if (isTestAnno) {
      Annotation annos[] = clazz.getAnnotations();
      for (Annotation anno : annos) {
        boolean is = anno instanceof Writer;
        if (is) {
          System.out.println(anno);
          System.out.println(anno);
        }
      }
    }
  }

}

@Writer(name = "test", age = 12)
class Test {
  @Writer(name = "miya", age = 10)
  public void writeBlog() {
    System.out.println("writing blog");
  }
}