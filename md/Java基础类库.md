# Java基础类库

## StringBuffer 类

* String类是所有开发中一定会用到的功能类，有如下特点
    * 每一个字符串的常量都属于一个String类的匿名对象，并且不可更改。
    * String有两个常量池：
        * 静态常量池
        * 运行时常量池
    * 实例化最好使用直接量，这样直接可以把对象保存在对象池之中。

* 弊端内容不允许修改，为了解决此问题，提供StringBuffer类。

* <strong>StringBuffer类必须实例化后才可用</strong>
    * 构造方法： public StringBuffer​()
    * 构造方法： public StringBuffer​(String str)
    * 数据追加： public StringBuffer append​(数据类型 数据)；


* String与StringBuffer区别

    * String

    ```java
        public class JavaDemo44 {
            private static String str = "hello";

            public static void main(String[] args) {
                concat(str);
                System.out.println(str); //hello
            }

            private static void concat(String temp) {
                temp += "word";
            }

        }
    ```

    * StringBuffer

    ```java
    public class JavaDemo44 {
        // private static String str = "hello";
        private static StringBuffer buf = new StringBuffer("hello");

        public static void main(String[] args) {
            // concat(str);
            concat(buf);
            // System.out.println(str); //hello
            System.out.println(buf); //hello word
        }

        private static void concat(String temp) {
            temp += "word";
        }
        private static void concat(StringBuffer temp) {
            temp.append( " word");
        }

    }
    ```