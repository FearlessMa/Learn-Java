package chapter0;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Writer {
  String name() default "writer";

  int age() default 10;
}