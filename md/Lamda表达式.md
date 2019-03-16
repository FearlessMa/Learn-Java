# Lamda表达式

* 函数式编程，可以避免掉面向对象之中的繁琐问题

```java

interface IMessage{
    public void send(String str);
}

public class JavaDemo30 {
    public static void main(String args[]) {
        IMessage msg = new IMessage(){
            //内部 匿名类
            @Override
            public void send(String str) {
                System.out.println("send " + str);
            }
        };

        msg.send("str"); //send str
    }
}

```

*  核心功能只有一行语句，实现起来过于复杂

* 使用lamda表达式

```java


@FunctionalInterface
interface IMessage {
    public void send(String str);
    public default void print(){
        System.out.println("函数式接口要求只有一个抽象方法！");
    }
}

public class JavaDemo30 {
    public static void main(String args[]) {
        IMessage msg = (str) -> {
            System.out.println("send " + str);
        };

        msg.send("str"); // send str
        msg.print(); // 函数式接口要求只有一个抽象方法！
    }
}
```

* lamda 表达式使用规则：
    * SAM(Single Abstract Method)，只有一个抽象方法
    * 只有一个抽象方法的接口称为函数式接口，只有函数式接口才可以被lamda表达式所使用
    * @FunctionalInterface 表示函数式接口注解

* lamda表达式格式
    * 方法没有参数：()->{}
    * 方法有参数: (参数,参数)->{}
    * 如果只有一行参数返回(与js箭头函数一样): ()->返回语句；
    ```java
        IMessage msg = str -> System.out.println("send " + str);
    ```

## 方法引用

* 引用数据类型最大的特点是可以进行内存的指向处理,传统开发之中一直使用的是对象的引用操作，jdk1.8之后提供方法的引用操作。即：不同方法名称可以描述同一个方法
    * 引用静态方法： 类名称::static方法名称
    * 引用实例对象方法： 实例化对象:: 普通方法
    * 引用特定类型的方法： 特定类:: 普通方法
    * 引用构造方法： 类名称:: new

* 引用静态方法 : 类名称::static方法名称
    * public static String valueOf​(int i)

    ```java
        @FunctionalInterface
        // P 参数 R 返回值
        interface IFunction<P, R> {
            public R change(P p);
        }

        public class JavaDemo31 {
            public static void main(String agrs[]) {
                IFunction<Integer, String> fun = String::valueOf;
                String c = fun.change(100);
                System.out.println(c + " 、" + c.length());
            }
        }
    ```

* 引用实例化对象中的方法 : 实例化对象:: 普通方法

    * public String toUpperCase​()

    ```java
        @FunctionalInterface
        interface IUpper<R> {
            public R upper();
        }

        public class JavaDemo31 {
            public static void main(String agrs[]) {
                IUpper<String>  u = "upper"::toUpperCase;
                System.out.println(u.upper());//UPPER
            }
        }
    ```

*  引用特定类型的方法： 特定类:: 普通方法

    * 普通方法如果不想实例化引用可以使用特定类

    * public int compareTo​(String anotherString)

    ```java
        @FunctionalInterface
        interface ICompare<P> {
            public int comp(P p1, P p2);
        }

        public class JavaDemo31 {
            public static void main(String agrs[]) {
                // IUpper<String> u = "upper"::toUpperCase;
                // System.out.println(u.upper());//UPPER

                ICompare<String> p = String :: compareTo;
                System.out.println(p.comp("A","a")); //-32
            }
        }
    ```

* 引用构造方法： 类名称:: new

```java

@FunctionalInterface
interface ICreate<R, P1, P2> {
    public R create(P1 p1, P2 p2);
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "name = " + this.name + "age = " + this.age;
    }
}

public class JavaDemo31 {
    public static void main(String agrs[]) {
        ICreate<Person, String, Integer> p1 = Person::new;
        Person per = p1.create("张三", 12);
        System.out.println(per.toString()); //name = 张三age = 12
    }
}
```

* 提供方法引用的概念在更多的情况下也只弥补了对于方法引用的支持功能


##  内建函数式接口

* jdk 1.8 之中提供lamda表达式和方法引用，系统中提供函数式接口

    * java.util.function的包里可以直接使用函数式接口

* 功能型函数式接口: 

    * 接口定义
        ```java
        @FunctionalInterface 
        public interface Function<T,R>{
            public T apply​(T t);
        }
        ```
    * 接口使用
        * 🌰  ： public boolean startsWith​(String prefix)
        ```java
            import java.util.function.*;
            public class JavaDemo31 {
                public static void main(String agrs[]) {
                    // 使用 public boolean startsWith​(String prefix)
                    Function<String, Boolean> f = "**start"::startsWith;
                    System.out.println(f.apply("**")); //true
                }
            }
        ```

* 消费型函数式接口 ： 只能进行数据的处理操作而没有任何的返回
    * 🌰  System.out.println();

    * 接口定义
        ```java
            @FunctionalInterface
            public interface Consumer<T>{
                public accept​(T t);
            }
        ```
    * 接口使用
        ```java
            import java.util.function.*;
            public class JavaDemo31 {
                public static void main(String agrs[]) {
                    Consumer<String> pri = System.out::println;
                    pri.accept​("Consumer"); //Consumer
                }
            }
        ```
* 供给型函数式接口 ： 没有接收参数，有返回值 。

    * 🌰  
        * 如： public String toLowerCase();
    
    * 接口定义
        ```java
            @FunctionalInterface
            public interface Supplier<T>{
                public T get​();
            }
        ```
    * 接口使用
        ```java
            import java.util.function.*;
            public class JavaDemo31 {
                public static void main(String agrs[]) {
                    //String实例"AAA"的toLowerCase方法传递给了 Supplier 类型 sup的get方法
                    Supplier<String> sup = "AAA"::toLowerCase;
                    System.out.print(sup.get()); //aaa
                }
            }
        ```

* 断言型函数式接口 ：进行判断处理
    * 🌰  
        * 如： public boolean equalsIgnoreCase​(String anotherString)
    
    * 接口定义
        ```java
            @FunctionalInterface
            public interface Predicate<T>{
                public boolean test​(T t);
            }
        ```
    * 接口使用
        ```java
            import java.util.function.*;
            public class JavaDemo31 {
                public static void main(String agrs[]) {
                    //String实例"AAA"的toLowerCase方法传递给了 Supplier 类型 sup的get方法
                    Predicate<String> pre = "aaa" :: equalsIgnoreCase;
                    System.out.println(pre.test("AAA"));//true
                }
            }
